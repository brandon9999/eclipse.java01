import java.util.Hashtable; 

import javax.management.MBeanServerConnection; 
import javax.management.MBeanServerInvocationHandler; 
import javax.management.ObjectName; 
import javax.management.remote.JMXConnector; 
import javax.naming.InitialContext; 
import javax.naming.Context; 

import jeus.jdbc.info.CPInfo; 
import jeus.jms.server.mbean.JMSDestinationResource; 
import jeus.jms.server.mbean.JMSDestinationResourceMBean; 
import jeus.management.JMXConstants; 
import jeus.management.RemoteMBeanServerFactory; 

import jeus.management.j2ee.JDBCResourceMBean; 


public class JEUS5Mbean { 

/** 
 * JMX Test 
 * @param args 
 */ 
public static void main(String[] args) throws Exception{ 
String nodeName = "mwt2"; 
String conName = "mwt2_container1"; 

Hashtable env = new Hashtable(); 
env.put("java.naming.security.principal", "administrator"); 
env.put("java.naming.security.credentials", "jeusadmin"); 
env.put("java.naming.factory.initial", "jeus.jndi.JEUSContextFactory"); 
env.put("java.naming.factory.url.pkgs", "jeus.jndi.jns.url"); 
env.put("java.naming.provider.url", "192.168.0.91:9736"); 
         
        //JEUS Util¿ª ≈Î«— MBeanServerConnection »πµÊ         
        MBeanServerConnection mbConn = RemoteMBeanServerFactory.getMBeanServer(env); 
         
        // JNDI ªÁøÎ«— MBeanServerConnection »πµÊ 
        /* 
        InitialContext ctx = new InitialContext(env); 
        String targetName = conName; 
        JMXConnector connector = (JMXConnector)ctx.lookup( 
        JMXConstants.JNDI_BINDING_PREFIX + targetName); 
        connector.connect(); 
        MBeanServerConnection mbConn = connector.getMBeanServerConnection(); 
        */ 
         
        // REMOTE API∏¶ ≈Î«—  MBeanServerConnection »πµÊ 
        /* 
        String targetName = args[0]; 
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/" + JMXConstants.JNDI_BINDING_PREFIX + targetName); 
        JMXConnector jmxconnector = (JMXConnector)JMXConnectorFactory.newJMXConnector(url,env); 
        jmxconnector.connect(); 
        MBeanServerConnection mbConn = jmxconnector.getMBeanServerConnection(); 
        */ 
         
        // JDBCConnectionInfoMBean »πµÊ 
         
        Class jdbcClaass = Class.forName("jeus.management.j2ee.JDBCResourceMBean");  
        ObjectName poolManagerName = new ObjectName("JEUS:j2eeType=JDBCResource,JMXManager=mwt2_container1,JeusManager=mwt2,J2EEServer=mwt2_container1,name=mwt2_container1"); 
        JDBCResourceMBean jdbcMBean = (JDBCResourceMBean)          
MBeanServerInvocationHandler.newProxyInstance(  
                mbConn,  
                poolManagerName,  
                jdbcClaass,  
false); 
         
         
        System.out.println("conName = "+jdbcMBean.getContainerName()); 
        CPInfo[] info = jdbcMBean.getCPInfo(); 
        for(int i=0;i<info.length;i++){ 
         System.out.println("cpinfo  = "+info[i].getName()); 
        } 
         
        Class jmsClaass = Class.forName("jeus.jms.server.mbean.JMSDestinationResourceMBean"); 
        ObjectName jmsManagerName = new ObjectName("JEUS:j2eeType=JeusService,jeusType=JMSDestinationResource,JMXManager=mwt2_container1,JeusManager=mwt2,J2EEServer=mwt2_container1,JMSResource=mwt2_jms_engine1,name=bpmQueue"); 
        JMSDestinationResourceMBean jmsMBean = (JMSDestinationResourceMBean)          
MBeanServerInvocationHandler.newProxyInstance(  
        mbConn,  
        jmsManagerName,  
        jmsClaass,  
false); 
         
        System.out.println("++++++++++++ "+jmsMBean.isQueue()); 
        System.out.println("++++++++++++ "+jmsMBean.getstats()); 
        jmsMBean.isQueue(); 
         
} 

} 

