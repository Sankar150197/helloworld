package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shopping.model.user;



public class userdao {
      private Connection con;
      private String query;
      private PreparedStatement ps;
      private ResultSet rs;
	public userdao(Connection con) 
	{
		this.con=con;
	}
	
      public user userlogin(String email,String password) {
    	  user user=null;
    	  try {
    		  query="select*from userlogin where email=? and password=?";
    		  ps=this.con.prepareStatement(query);
    		  ps.setString(1, email);
    		  ps.setString(2, password);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			user=new user();
    			user.setId(rs.getInt("id"));
    			user.setName(rs.getString("name"));
    			user.setEmail(rs.getString("email"));
    			user.setPassword(rs.getString("password"));
    			
    		}
    		  
    	  }catch(Exception e) {
    	  e.printStackTrace();
    	  System.out.println(e.getMessage());
      }
      
      return user;
}
      
}

