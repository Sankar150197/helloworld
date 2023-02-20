package shopping.servlet;

import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.connection.dbcon;
import shopping.dao.OrderDao;
import shopping.dao.userdao;



@WebServlet("/cancelorder")
public class cancelorder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			if(id != null) {
				userdao orderDao = new userdao(dbcon.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("orders.jsp");
		} 
	}
  

}
