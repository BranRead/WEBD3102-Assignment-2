package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.brandon.assignment2.database.ShoppingCartDAOImp;
import com.brandon.assignment2.model.ShoppingCartItem;
import com.brandon.assignment2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CartViewControllerServlet", value = "/view-cart.jsp")
public class CartViewController extends HttpServlet {
    ShoppingCartDAOImp shoppingCartDAOImp = new ShoppingCartDAOImp();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        try {
            List<ShoppingCartItem> shoppingCartItems = shoppingCartDAOImp.selectAll(user.getId());
            float totalCost = 0;
            for (ShoppingCartItem item:
                 shoppingCartItems) {
                totalCost += item.getCost() * item.getQuantityInCart();
            }
            request.getSession().setAttribute("cart", shoppingCartItems);
            request.setAttribute("totalCost", totalCost);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("/cart.jsp");
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}