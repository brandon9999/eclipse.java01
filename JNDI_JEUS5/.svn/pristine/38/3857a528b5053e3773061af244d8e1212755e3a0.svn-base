/*
 * [Compile - JEUS4]
 * javac -classpath C:\TmaxSoft\JEUS4.2.4.5\lib\system\jeus.jar;
 *                  C:\TmaxSoft\JEUS4.2.4.5\lib\system\jmxri.jar;
 *                  C:\TmaxSoft\JEUS5.0.23\lib\datasource\ojdbc14.jar;. -d . DBTest.java
 * 
 * [Compile - JEUS5] 
 * javac -classpath $JEUS_HOME/lib/system/jeus.jar:
 *                  $JEUS_HOME/lib/system/jeusmbean.jar:
 *                  $JEUS_HOME/lib/datasource/ojdbc14.jar:. -d . DBTest.java
 *
 * [Run - JEUS4]
 * java -classpath C:\TmaxSoft\JEUS4.2.4.5\lib\system\jeus.jar;
 *                 C:\TmaxSoft\JEUS4.2.4.5\lib\system\jmxri.jar;
 *                 C:\TmaxSoft\JEUS5.0.23\lib\datasource\ojdbc14.jar;. 
 *                 -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory DBTest
 * 
 * [Run - JEUS5]
 * java -classpath $JEUS_HOME/lib/system/jeus.jar:
 *                 $JEUS_HOME/lib/system/jeusmbean.jar:
 *                 $JEUS_HOME/lib/system/jeusutil.jar:
 *                 $JEUS_HOME/lib/system/jeusjaxb.jar:
 *                 $JEUS_HOME/lib/system/jaxb-api.jar:
 *                 $JEUS_HOME/lib/system/jaxb-libs.jar:
 *                 $JEUS_HOME/lib/system/jaxb-impl.jar:
 *                 $JEUS_HOME/lib/datasource/ojdbc14.jar:. 
 *                 -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory DBTest
 */

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;
import javax.sql.DataSource;
import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;
import java.util.Properties;
public class DBTest 
{
	public static void main(String[] args) 
	{
		Connection  con=null;
		System.out.println("---START---");
		String dsName = "kisdb1";
		DataSource ds = null;
		System.out.println("WAS DB PoolName : "+dsName);
		try 
		{
			long saveTime = System.currentTimeMillis();
			System.out.println("before InitialContext()"+System.currentTimeMillis());
			Hashtable<String, String> ht = new Hashtable<String, String>();
			ht.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JEUSContextFactory");
			ht.put(Context.URL_PKG_PREFIXES, "jeus.jndi.jns.url");
			ht.put(Context.PROVIDER_URL, "testmwt.iptime.org:9736");
			Context ic = new InitialContext(ht);
			System.out.println("After InitialContext()"+System.currentTimeMillis());
			ds = (DataSource)ic.lookup(dsName);
			System.out.println("lookup"+System.currentTimeMillis());
			con = ds.getConnection();
			System.out.println("DB connetion");
			System.out.println("DB connetion" +con.toString());
			
			long lastTime = System.currentTimeMillis();
			long Time = lastTime-saveTime;
			System.out.println("end == " +Time/1000);
			DatabaseMetaData metaData = con.getMetaData();
			System.out.println(
					"Database Name: " + metaData.getDatabaseProductName() +
					"Database Version: " + metaData.getDatabaseProductVersion() +
					"Driver Name: " + metaData.getDriverName() +
					"Driver Version: " + metaData.getDriverVersion() +
					"URL: " + metaData.getURL()
			);
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

