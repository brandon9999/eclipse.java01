/**
 * JEUS Thread Info
 */

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.management.AttributeNotFoundException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.j2ee.statistics.Statistic;
import javax.management.remote.JMXConnector;
import javax.naming.Context;
import javax.naming.InitialContext;

import jeus.management.JMXConstants;
import jeus.management.RemoteMBeanServerFactory;
import jeus.management.snmp.adaptor.SnmpSupportList;

public class JeusThreadInfo
{
	public static void main(String args[]) throws Exception
	{
		JeusThreadInfo test = new JeusThreadInfo();
		test.process();
	}
	
	public void process() throws Exception
	{
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JEUSContextFactory");
        env.put(Context.PROVIDER_URL, "192.168.0.91:9736");
        env.put(Context.SECURITY_PRINCIPAL, "administrator");
        env.put(Context.SECURITY_CREDENTIALS, "jeusadmin");
        
/**
*         JNDI를 통한 MBeanServerConnection 획득
*/     
        
		String nodeName = "mwt2"; 
		String conName = "mwt2_container1";         

        InitialContext ctx = new InitialContext(env); 
        String targetName = conName; 
        JMXConnector connector = (JMXConnector)ctx.lookup( 
        JMXConstants.JNDI_BINDING_PREFIX + targetName); 
        connector.connect(); 
        MBeanServerConnection mbConn = connector.getMBeanServerConnection(); 		

/**
 *         JEUS Util을 통한 MBeanServerConnection 획득
 */        
        //MBeanServerConnection mbConn = RemoteMBeanServerFactory.getMBeanServer(env);
		
        String key = "ThreadPoolMo";
        Vector attrs = new Vector();
        attrs.add("objectName");
        attrs.add("threadState_ALL_INFO");
        attrs.add("allThreadCount-count"); // 전체 할당된 Thread의 개수
        attrs.add("activeThreadCount-count"); // execute-현재 실행 중인 Thread의 개수
        attrs.add("blockThreadCount-count"); // pending-현재 pending된 Thread의 개수

        try 
        {
            getData(mbConn, attrs, key);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }


    private int getMaxAvgTime(String _strInfo) 
    {
        int nMaxAvgTime = 0;
        int nCurrIndex = 0;

        while(true) {
            nCurrIndex = _strInfo.indexOf(", avgTime=", nCurrIndex);
            if(nCurrIndex == -1)
                break;

            int nLastIndex = _strInfo.indexOf(" ms", nCurrIndex);
            String strAvgTime = _strInfo.substring(nCurrIndex + 10, nLastIndex);
            nCurrIndex = nLastIndex;

            nMaxAvgTime = Math.max(nMaxAvgTime, Integer.parseInt(strAvgTime));
        }

        return nMaxAvgTime;
    }
    
    public void getData(MBeanServerConnection connector, Vector _vAttrs, String _strKey) throws Exception
    {
        Hashtable queries = SnmpSupportList.classes;
        String queryString = (String)queries.get(_strKey);

        try 
        {
            ObjectName scope = new ObjectName("JEUS:" + queryString + ",*");
            Set set = connector.queryNames(scope, null);

            Vector vSubMsgs = new Vector();
            for(Iterator i = set.iterator(); i.hasNext();) 
            {
                ObjectName obj = (ObjectName)i.next();

                for(int ii = 0; ii < _vAttrs.size(); ii++) 
                {
                    String wholeAttributeName = (String)_vAttrs.get(ii);

                    Vector attributeNameVector = tokenize(wholeAttributeName, "-");
                    String attributeName = (String)attributeNameVector.get(0);

                    attributeName = attributeName.substring(0, 1).toLowerCase() + attributeName.substring(1);

                    Object returnObject = null;

                    if(attributeNameVector.size() > 1) {
                        try {
                            returnObject = connector.getAttribute(obj, attributeName);

                            if((returnObject != null) & returnObject instanceof Statistic) {
                                returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                            }
                        }
                        catch(AttributeNotFoundException e) {}
                        catch(Throwable t) {
                            try {
                                returnObject = connector.getAttribute(obj, attributeName.substring(0, 1).toUpperCase()
                                    + attributeName.substring(1));

                                if((returnObject != null) & returnObject instanceof Statistic) {
                                    returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                                }
                            }
                            catch(AttributeNotFoundException e) {}
                            catch(Throwable tt) {}
                        }

                        if(returnObject == null) {
                            try {
                                Object callObject = connector.getAttribute(obj, "stats");
                                returnObject = recursiveInvoke(callObject, attributeNameVector, null, 0);
                            }
                            catch(AttributeNotFoundException e) {}
                        }
                    }
                    else {
                        try {
                            returnObject = connector.getAttribute(obj, attributeName);

                            if(returnObject instanceof Statistic) {
                                returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                            }
                        }
                        catch(AttributeNotFoundException e) {}
                        catch(Throwable t) {
                            try {
                                returnObject = connector.getAttribute(obj, attributeName.substring(0, 1).toUpperCase()
                                    + attributeName.substring(1));

                                if(returnObject instanceof Statistic) {
                                    returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                                }
                            }
                            catch(AttributeNotFoundException e) {}
                            catch(Throwable tt) {
                                Object callObject = null;

                                try {
                                    callObject = connector.getAttribute(obj, "stats");
                                }
                                catch(AttributeNotFoundException e) {}
                                catch(Throwable ttt) {}

                                try {
                                    returnObject = recursiveInvoke(callObject, attributeNameVector, null, 0);
                                }
                                catch(Throwable tttt) {
                                    returnObject = null;
                                }
                            }
                        }
                    }

                    if(returnObject == null) {
                        continue;
                    }

                    Class returnClass = returnObject.getClass();

                    if(returnClass.isArray()) {
                        Object[] returnArray = (Object[])returnObject;

                        Vector v = new Vector();
                        for(int jj = 0; jj < returnArray.length; jj++) {
                            v.addElement(returnArray[jj]);
                        }
                    }
                    else 
                    {
                        if(returnObject.toString().equals("[]"))
                            returnObject = "0";
                        
                        ////////////////////////////////////////////////////////////////////////////////
                        if(wholeAttributeName.compareTo("allThreadCount-count") == 0)
                        {
                        	System.out.println("All Thread Count : "+returnObject.toString());
                        }
                        
                        if(wholeAttributeName.compareTo("activeThreadCount-count") == 0)
                        {
                        	System.out.println("Active Thread Count :"+returnObject.toString());
                        }
                        
                        if(wholeAttributeName.compareTo("blockThreadCount-count") == 0)
                        {
                        	System.out.println("Pending Thread Count : "+returnObject.toString());
                        }
                        ///////////////////////////////////////////////////////////////////////////////////
                    }
                }
            }
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        	throw e;
        }
    }   
    
    public Object recursiveInvoke(Object callObject, Vector attributeNameVector, Object[] methodArgs, int depth)  throws Exception 
	{
	    Object returnObject = null;
	    Class callClass = callObject.getClass();
	    String methodName = "get" + (String)attributeNameVector.get(depth);
	    Class[] methodClass = null;
	    java.lang.reflect.Method method = callClass.getMethod(methodName, methodClass);
	    returnObject = method.invoke(callObject, methodArgs);
	
	    if(returnObject == null) {
	        return "";
	    }
	
	    Class returnClass = returnObject.getClass();
	    Object[] returnObjectArray = null;
	
	    int endOfDepth = attributeNameVector.size() - 1;
	
	    if(depth == endOfDepth) 
	    {
	        return returnObject;
	    }
	    else if(returnClass.isArray()) 
	    {
	        returnObjectArray = (Object[])returnObject;
	
	        Vector returnValueVector = new Vector();
	
	        for(int j = 0; j < returnObjectArray.length; j++) {
	            returnObject = recursiveInvoke(returnObjectArray[j], attributeNameVector, methodArgs, depth + 1);
	
	            if(depth < endOfDepth) {
	                returnValueVector.add(returnObject);
	            }
	        }
	
	        return returnValueVector;
	    }
	    else 
	    {
	        returnObject = recursiveInvoke(returnObject, attributeNameVector, methodArgs, depth + 1);
	        return returnObject;
	    }
	}	
	
    public Vector tokenize(String str, String delim) {
        Vector tokens = new Vector();

        for(StringTokenizer tokenizer = new StringTokenizer(str); tokenizer.hasMoreTokens();) {
            String token = tokenizer.nextToken(delim);
            token = token.substring(0, 1).toUpperCase() + token.substring(1);
            tokens.add(token);
        }

        return tokens;
    }    
}
