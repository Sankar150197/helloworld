package shopping.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.model.*;


/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class Addtocart extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
//        	out.print("add to cart servlet");

            ArrayList<cart> cartList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            cart cm = new cart();
            cm.setId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
			ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else {
                cartList = cart_list;

                boolean exist = false;
                for (cart c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }

                if (!exist) {
                    cartList.add(cm);
                    response.sendRedirect("index.jsp");
                }
            }
        }
	}

}
