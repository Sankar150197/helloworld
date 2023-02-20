package shopping.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import shopping.model.*;

public class productdao {
	     private Connection con;
	     private String query;
	     private PreparedStatement ps;
	     private ResultSet rs;
	     public productdao(Connection con) 
	 	{
	 		this.con=con;
	 	}
	 	 public List<product> getallproducts(){
	 		  List<product> products=new ArrayList<product>();
	 		  try {
	 			    query="select*from products";
	 			       ps  = this.con.prepareStatement(query);
	 			       rs=ps.executeQuery();
	 			       while(rs.next()) {
	 			    	   product row =new product();
	 			    	   row.setId(rs.getInt("id"));
	 			    	   row.setProductname(rs.getString("productname"));
	 			    	   row.setCategery(rs.getString("catagery"));
	 			    	   row.setPrice(rs.getInt("price"));
	 			    	   
	 			    	products.add(row) ;  
	 			       }
	 		  }catch(Exception e) {
	 			  e.printStackTrace();
	 		  }
	 		  
	 		  
	 		  return products;
	 	 }

	        
	}


