/*
 JMS SVR : JEUS 5.0.0.26 sample
*/

package jms.topic;

import java.io.*;
import java.util.*;
import javax.jms.*;
import javax.naming.*;
import javax.transaction.*;

public class TopicReceive implements MessageListener
{
   private TopicConnectionFactory tconFactory;
   private TopicConnection tcon;
   private TopicSession tsession;
   private TopicSubscriber tsubscriber;
   private Topic topic;
   private boolean quit = false;

   /**
   * MessageListener interface.
   */
   public void onMessage(Message msg)
   {
      try
      {
         String msgText;

         if (msg instanceof TextMessage)
         {
            msgText = ((TextMessage)msg).getText();
         }
         else
         {
            msgText = msg.toString();
         }

         System.out.println("JMS Message Received: " + msgText);
      }
      catch (JMSException jmse)
      {
         jmse.printStackTrace();
      }
   }

   /**
   * Create connection.
   * Create session from connection; false means session is
   * not transacted.
   * Create Asychronous Subscriber.
   * Finally, start connection.
   */
   public void init(Context ctx, String topicName) throws NamingException, JMSException
   {
      tconFactory = (TopicConnectionFactory)ctx.lookup("TopicConnectionFactory");
      tcon = tconFactory.createTopicConnection();
      tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
      topic = (Topic)ctx.lookup(topicName);
      tsubscriber = tsession.createSubscriber(topic);
      tsubscriber.setMessageListener(this);
      tcon.start();
   }

   /**
   * Close any connections opened by the tests.
   */
   public void close() throws JMSException
   {
      tsubscriber.close();
      tsession.close();
      tcon.close();
   }

   /**
    * Main method.
    *
    * @param args
    */
   public static void main(String[] args) throws Exception
   {
      //Context initial = new InitialContext();
	   
	  Context initial = null;
	  Hashtable ht = new Hashtable();
	  ht.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JEUSContextFactory");
	  ht.put(Context.URL_PKG_PREFIXES, "jeus.jndi.jns.url");
	  ht.put(Context.PROVIDER_URL, "192.168.1.220:29736");
//	  ht.put(Context.SECURITY_PRINCIPAL, ¡°peter¡±);
//	  ht.put(Context.SECURITY_CREDENTIALS, ¡°golf42¡±);

	  initial = new InitialContext(ht);	   
	   
      TopicReceive tr = new TopicReceive();
      tr.init(initial, "ExampleTopic");

      System.out.println("JMS Ready To Receive Messages.");

      // Wait for 20 seconds.
      Thread.sleep(20000);
      tr.close();
   }
}