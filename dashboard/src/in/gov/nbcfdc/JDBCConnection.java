package in.gov.nbcfdc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCConnection {
	
		
	    static String DB_DRIVER_CLASS="";
	    static String DB_URL = ""; 
	    static String USER = "";
	    static String PASS = ""; 
	    
	    
	    
		public static void getResourceValues() throws IOException {
			
			 InputStream inputStream = null;
	 
			try {
				Properties props = new Properties();

				inputStream = JDBCConnection.class.getClassLoader().getResourceAsStream("config.properties");
	 
				if (inputStream != null) {
					props.load(inputStream);
				} else {
					throw new FileNotFoundException("property file  not found in the classpath");
				}
	 
				DB_DRIVER_CLASS =props.getProperty("DB_DRIVER_CLASS");
				DB_URL = props.getProperty("DB_URL");
				USER = props.getProperty("USER");
				PASS = props.getProperty("PASS");
	 
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
			
		}		

	public static Connection getConnection()  {
		
		try {
			getResourceValues();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		   Connection conn = null;
	   
		   try{
			      //STEP 2: Register JDBC driver
			        Class.forName(DB_DRIVER_CLASS);

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
			    			    		        
			     }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
			   			   
		   return conn;
		}
	

	
}
	 
	 


