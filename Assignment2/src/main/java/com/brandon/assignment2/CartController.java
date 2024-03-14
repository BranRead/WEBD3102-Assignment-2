package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brandon.assignment2.database.ShoppingCartDAOImp;
import com.brandon.assignment2.model.ShoppingCartItem;
import com.brandon.assignment2.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CartControllerServlet", value = "/cart")
public class CartController extends HttpServlet {

    ShoppingCartDAOImp shoppingCartDAOImp = new ShoppingCartDAOImp();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") != null) {
            try {
                addItem(request, response);
//                if(request.getParameter("delete") != null) {
//                    delete(request, response);
//                }
//
//                if(request.getParameter("change") != null) {
//                    change(request, response);
//                }
            } catch (SQLException | ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            User user = (User) request.getSession().getAttribute("user");

            List<ShoppingCartItem> existingShoppingCart = shoppingCartDAOImp.selectAll(user.getId());

            boolean isAlreadyInCart = false;
            int quantity = 0;

            for (ShoppingCartItem item:
                 existingShoppingCart) {
                if(item.getId() == Integer.parseInt(request.getParameter("productId"))) {
                    isAlreadyInCart = true;
                    quantity = item.getQuantityInCart();
                }
            }

            if(isAlreadyInCart) {
                shoppingCartDAOImp.modify(Integer.parseInt(request.getParameter("quantity")) + quantity, Integer.parseInt(request.getParameter("productId")), user.getId());
            } else {
                shoppingCartDAOImp.add(user.getId(), Integer.parseInt(request.getParameter("productId")), Integer.parseInt(request.getParameter("quantity")));
            }


            request.setAttribute("id", user.getId());
            request.setAttribute("productId", Integer.parseInt(request.getParameter("productId")));
            request.setAttribute("quantity", Integer.parseInt(request.getParameter("quantity")));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("/main.jsp");
        } catch (ServletException | IOException | SQLException e) {
            shoppingCartDAOImp.add(0, 0, 0);
            throw new RuntimeException(e);
        }

    }

//    private void delete(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//    }
//
//    private void change(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//    }
        public void destroy(){
        }
    }