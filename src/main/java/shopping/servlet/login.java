package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.connection.dbcon;
import shopping.dao.userdao;
import shopping.model.user;

/**
 * Servlet implementation class login
 */
@WebServlet("/user-login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	              response.setContentType("text/html");
	              try(PrintWriter out=response.getWriter()){
	            	  String email=request.getParameter("login-email");
	            	  String password=request.getParameter("login-password");
	            	  
	            	   userdao us=new userdao(dbcon.getConnection());
	                   user user=us.userlogin(email, password);
	                   
	            	    if(user !=null) {
	            	    	
	            	    	request.getSession().setAttribute("auth", user);
	            	    	out.print("hello");
	            	    	response.sendRedirect("index.jsp");
	            	    
	            	    	
	            	    } else {
	            	    	out.print("user login failed");
	            	    }
	            	  
	            	  
	            
	              }
	}  

}
