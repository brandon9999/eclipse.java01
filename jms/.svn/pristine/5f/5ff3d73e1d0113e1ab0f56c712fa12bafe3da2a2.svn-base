/*
 *  JMS SVR : JEUS 5.0.0.26 sample
        ## SyncMsgSend.java
*/
package jms.sync;

import java.io.*;

import java.util.*;

import javax.jms.*;

import javax.naming.*;


public class SyncMsgSend
{
   public final static StringBuffer buffer = new StringBuffer();
   private QueueConnectionFactory qconFactory;
   private QueueConnection qcon;
   private QueueSession qsession;
   private QueueSender qsender;
   private javax.jms.Queue queue;
   private MapMessage mapmsg;

   public void init(Context ctx, String queueName) throws NamingException, JMSException
   {
      qconFactory = (QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");
      qcon = qconFactory.createQueueConnection();
      qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      queue = (javax.jms.Queue)ctx.lookup(queueName);
      qsender = qsession.createSender(queue);
      mapmsg = qsession.createMapMessage();

      qcon.start();
   }

   public void close() throws JMSException
   {
      qsender.close();
      qsession.close();
      qcon.close();
   }

   public static void main(String[] args) throws Exception
   {
      //InitialContext initial = new InitialContext();
      
      
	  Context initial = null;
	  Hashtable ht = new Hashtable();
	  ht.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JEUSContextFactory");
	  ht.put(Context.URL_PKG_PREFIXES, "jeus.jndi.jns.url");
	  ht.put(Context.PROVIDER_URL, "192.168.1.220:29736");
//	  ht.put(Context.SECURITY_PRINCIPAL, ¡°peter¡±);
//	  ht.put(Context.SECURITY_CREDENTIALS, ¡°golf42¡±);

	  initial = new InitialContext(ht);   
      
      
      SyncMsgSend sender = new SyncMsgSend();
      sender.init(initial, "ExampleQueue");
      sender.send();
      sender.close();
   }

   public void send() throws JMSException
   {
//              mapmsg.setInt("id", 24);
      mapmsg.setString("name", "John Smith");

//              mapmsg.setDouble("salary", 600.00);
      mapmsg.setString("department", "Human Resources Development");
      qsender.send(mapmsg);
   }
}