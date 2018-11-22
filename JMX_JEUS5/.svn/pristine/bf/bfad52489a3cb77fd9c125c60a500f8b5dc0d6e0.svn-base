import java.io.*;
import java.util.*;

import jeus.server.service.*;
import jeus.management.*;
import jeus.management.j2ee.*;
import jeus.connector.stats.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.j2ee.statistics.*;
import javax.naming.Context;
import javax.naming.InitialContext;



public class JMXTest {


    public static HashMap attributes = new HashMap();


    public static void main(String[] args) {

		final String url = "192.168.0.91:9736";
        String host = "mwt2";
		//String host = "192.168.0.91";
        String id = "administrator";
        String pw = "jeusadmin";
        String target = null;


        try {

            if ( args.length == 1 ) {
                target = args[0];
            } else if ( args.length == 2 ) {
                host = args[0];
                target = args[1];
            } else if ( args.length == 4 ) {
                host = args[0];
                id = args[1];
                pw = args[2];
                target = args[3];
            } else {
                System.out.println("[Error] invalid arguments\n");
                System.out.println("Usage1) java JMXTest {TARGET}");
                System.out.println("Usage2) java JMXTest {JEUS container name} {TARGET}");
                System.out.println("Usage3) java JMXTest {JEUS container name} {jeus id} {jeus pw} {TARGET}\n");
                System.out.println("TARGET - \"all\" or one of following mbean names");

                Set set = attributes.keySet();
                for(Iterator i = set.iterator(); i.hasNext();) {
                    String key = (String)i.next();
                    System.out.println("         " + key);
                }
                System.exit(-1);
            }


			Object obj[] = getContainerList(host, url, id, pw);


            for(int i = 0;i < obj.length;i++){

				ObjectName j2eeServers = new ObjectName((String)obj[i]);
				String containerName = j2eeServers.getKeyProperty("name");

                System.out.println("********************** " + containerName + " **********************");

	            MBeanServerConnection connector = (MBeanServerConnection)RemoteMBeanServerFactory.getDedicatedMBeanServer(containerName, id, pw, false);
	            
	            if (target.equals("all")) {
	
	                Set set = attributes.keySet();
	                for(Iterator j = set.iterator(); j.hasNext();) {
	                    System.out.println("===============================================================================");
	                    String key = (String)j.next();
	                    testMbean(connector, attributes, key);
	                }
	                System.out.println("===============================================================================");
	
	            } else {
	
	                if (target != null && !target.equals("")) {
	                    testMbean(connector, attributes, target);
	                } else {
	                    System.out.println("[Error] mbean name is invalid");
	                }
	
	            }

            }           

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

	
	private static Object[] getContainerList(String host, String url, String id, String pw) throws Exception {

        try {
        	
	        MBeanServerConnection connector = (MBeanServerConnection)RemoteMBeanServerFactory.getDedicatedMBeanServer(host, id, pw, true);

			ObjectName obj = new ObjectName("JEUS:j2eeType=J2EEDomain,JMXManager=" + host + ",name=JeusSystem");
			Object returnObject = connector.getAttribute(obj, "servers");
            Object[] returnArray = (Object[])returnObject;

			return returnArray;
			
						
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }

	}
	

    private static Vector tokenize(String str, String delim) {

        Vector tokens = new Vector();

        for(StringTokenizer tokenizer = new StringTokenizer(str); tokenizer.hasMoreTokens();) {
            String token = tokenizer.nextToken(delim);
            token = token.substring(0, 1).toUpperCase() + token.substring(1);
            tokens.add(token);
        }

        return tokens;

    }


    private static Object recursiveInvoke(Object callObject, Vector attributeNameVector, Object[] methodArgs, int depth) throws Exception {

        Object returnObject = null;
        Class callClass = callObject.getClass();
        String methodName = "get" + (String)attributeNameVector.get(depth);
        Class[] methodClass = null;
        java.lang.reflect.Method method = callClass.getMethod(methodName, methodClass);
        returnObject = method.invoke(callObject, methodArgs);

        if (returnObject == null) {
            return "";
        }

        Class returnClass = returnObject.getClass();
        Object[] returnObjectArray = null;

        int endOfDepth = attributeNameVector.size() - 1;

        if (depth == endOfDepth) {

            return returnObject;

        } else if (returnClass.isArray()) {

            returnObjectArray = (Object[])returnObject;
            Vector returnValueVector = new Vector();
            for (int j = 0; j < returnObjectArray.length; j++) {
                returnObject = recursiveInvoke(returnObjectArray[j], attributeNameVector, methodArgs, depth + 1);
                if (depth < endOfDepth) {
                   returnValueVector.add(returnObject);
                }
            }

            return returnValueVector;
        } else {

            returnObject = recursiveInvoke(returnObject, attributeNameVector, methodArgs, depth + 1);
            return returnObject;

        }

    }



    private static void testMbean(MBeanServerConnection connector, HashMap attributes, String key) {

        try {

            String queryString = ((MonitorList)attributes.get(key)).getQuery();
            System.out.println("<><><><> Query is : " + queryString);

            ObjectName scope = new ObjectName("JEUS:" + queryString + ",*");

            Set set = connector.queryNames(scope, null);
            System.out.println("<><><><> Mbean = " + key + " ### Count of " + key + " Mbean = " + set.size());

            for(Iterator i = set.iterator(); i.hasNext();) {
                System.out.println("-------------------------------------------------------------------------------");
                ObjectName obj = (ObjectName)i.next();
                Vector attrs = ((MonitorList)attributes.get(key)).getAttributes();

                for (int ii = 0; ii < attrs.size(); ii++) {

                    String wholeAttributeName = (String)attrs.get(ii);
                    Vector attributeNameVector = tokenize(wholeAttributeName, "-");
                    String attributeName = (String)attributeNameVector.get(0);
                    attributeName = attributeName.substring(0, 1).toLowerCase() + attributeName.substring(1);

                    Object returnObject = null;

                    if (attributeNameVector.size() > 1) {

                        try {
                            returnObject = connector.getAttribute(obj, attributeName);

                            if ((returnObject != null) & returnObject instanceof Statistic) {
                                returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                            }
                        } catch(Throwable t) {
                            try {
                                returnObject = connector.getAttribute(obj, attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1));

                                if ((returnObject != null) & returnObject instanceof Statistic) {
                                    returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                                }
                            } catch(Throwable tt) {
                            }
                        }

                        if (returnObject == null) {
                            Object callObject = connector.getAttribute(obj, "stats");
                            returnObject = recursiveInvoke(callObject, attributeNameVector, null, 0);
                        }

                    } else {

                        try {
                            returnObject = connector.getAttribute(obj, attributeName);

                            if (returnObject instanceof Statistic) {
                                returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                            }
                        } catch(Throwable t) {
                            try {
                                returnObject = connector.getAttribute(obj, attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1));

                                if (returnObject instanceof Statistic) {
                                    returnObject = recursiveInvoke(returnObject, attributeNameVector, null, 1);
                                }
                            } catch(Throwable tt) {
                                Object callObject = null;

                                try {
                                    callObject = connector.getAttribute(obj, "stats");
                                } catch(Throwable ttt) {
                                }

                                try {
                                    returnObject = recursiveInvoke(callObject, attributeNameVector, null, 0);
                                } catch(Throwable tttt) {
                                    returnObject = null;
                                }
                            }
                        }
                    }

                    if (returnObject == null) {
                        System.out.println(wholeAttributeName + " is null");
                        continue;
                    }

                    Class returnClass = returnObject.getClass();

                    if (returnClass.isArray()) {
                        Object[] returnArray = (Object[])returnObject;
                        for (int jj = 0; jj < returnArray.length; jj++) {
                            System.out.println(wholeAttributeName + "[" + jj + "]=" + returnArray[jj]);
                        }
                    } else {
                        System.out.println(wholeAttributeName + "=" + returnObject);
                    }

                }

            }


        } catch (Throwable t) {
            t.printStackTrace();
        }

    }



    static {

        MonitorList monList = null;
        Vector attrs = null;

        attrs = new Vector();
        attrs.add("objectName");
        attrs.add("min");
        attrs.add("max");
        attrs.add("step");
        attrs.add("maxIdleTime");
        attrs.add("maxQueue");
        attrs.add("maxWaitQueue");
        attrs.add("activeThreadCount-count");
        attrs.add("blockThreadCount-count");
        attrs.add("allThreadCount-count");
        attrs.add("maxThreadCount-count");
        attrs.add("waitQueueCount-count");
        attrs.add("threadState_ALL_INFO");
        monList = new MonitorList("j2eeType=JeusService,jeusType=ThreadPool_WEBC", attrs);
        attributes.put("ThreadPoolMo", monList);

        attrs = new Vector();
        attrs.add("objectName");
        attrs.add("server");
        attrs.add("contextGroupObjectName");
        attrs.add("realDocBase");
        attrs.add("moduleType");
        attrs.add("autoReload");
        attrs.add("requestCount-count");
        attrs.add("allSessionsSize-count");
        attrs.add("activeSessionsSize-count");
        attrs.add("passivateSessionsSize-count");
        attrs.add("localSessionsSize-count");
        attrs.add("processingTime-count");
        monList = new MonitorList("j2eeType=WebModule", attrs);
        attributes.put("WebModule", monList);

        attrs = new Vector();
        attrs.add("objectName");
        attrs.add("jdbcDataSource");
        attrs.add("config");
        attrs.add("cPInfo");
        attrs.add("createCount-count");
        attrs.add("closeCount-count");
        attrs.add("poolSize-upperBound");
        attrs.add("poolSize-lowerBound");
        attrs.add("poolSize-highWaterMark");
        attrs.add("poolSize-lowWaterMark");
        attrs.add("poolSize-current");
        attrs.add("freePoolSize-upperBound");
        attrs.add("freePoolSize-lowerBound");
        attrs.add("freePoolSize-highWaterMark");
        attrs.add("freePoolSize-lowWaterMark");
        attrs.add("freePoolSize-current");
        attrs.add("waitingThreadCount-highWaterMark");
        attrs.add("waitingThreadCount-lowWaterMark");
        attrs.add("waitingThreadCount-current");
        attrs.add("reConnectCount-count");
        attrs.add("waitTime-count");
        attrs.add("waitTime-maxTime");
        attrs.add("waitTime-minTime");
        attrs.add("waitTime-totalTime");
        attrs.add("useTime-count");
        attrs.add("useTime-maxTime");
        attrs.add("useTime-minTime");
        attrs.add("useTime-totalTime");
        monList = new MonitorList("j2eeType=JDBCDataSource", attrs);
        attributes.put("JDBCDataSource", monList);

    }


    static class MonitorList extends Object {

        private String query;
        private Vector attrs;

        MonitorList() {}
        MonitorList(String query, Vector attrs) { setQuery(query); setAttributes(attrs); }
        String getQuery() { return query; }
        Vector getAttributes() { return attrs; }
        void setQuery(String query) { this.query = query; }
        void setAttributes(Vector attrs) { this.attrs = attrs; }

    }

}
