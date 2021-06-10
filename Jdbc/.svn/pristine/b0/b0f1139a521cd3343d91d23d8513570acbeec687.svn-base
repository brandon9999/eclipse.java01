import java.sql.*; 
import oracle.jdbc.driver.*; 

public class JDBCVersion { 
         public static void main (String args []) throws SQLException { 

                 // Load the Oracle JDBC driver 
                 DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver()); 

                 //  Change the following code line to reflect a valid connection to your 
                 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.91:1521:ORCL","scott","tiger"); 

                // Create Oracle DatabaseMetaData object 
                DatabaseMetaData meta = conn.getMetaData (); 

                // gets driver info: 
                System.out.println("\n=============\nDatabase Product Name is ... " + meta.getDatabaseProductName()); 
                System.out.println("\nDatabase Product Version is  " + meta.getDatabaseProductVersion()); 
                System.out.println("\n=============\nJDBC Driver Name is ........ " + meta.getDriverName()); 
                System.out.println("\nJDBC Driver Version is ..... " + meta.getDriverVersion()); 
                System.out.println("\nJDBC Driver Major Version is " + meta.getDriverMajorVersion()); 
                System.out.println("\nJDBC Driver Minor Version is " + meta.getDriverMinorVersion()); 
                System.out.println("\n============="); 
       } 
} 
