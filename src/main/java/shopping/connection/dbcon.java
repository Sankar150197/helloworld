package shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcon {
     private static Connection connection=null;
     
     public static Connection getConnection()  {
    	 
    	 if(connection==null) {
    		 try {
				Class.forName("com.mysql.jdbc.Driver");
			connection	=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Sankar@97");
			System.out.println("connected");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	 }
		return connection;
    	 
     }
}
