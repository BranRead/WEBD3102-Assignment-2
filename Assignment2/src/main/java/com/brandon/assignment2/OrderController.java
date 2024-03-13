package com.brandon.assignment2;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.brandon.assignment2.database.AddressDAOImp;
import com.brandon.assignment2.database.OrderDAOImp;
import com.brandon.assignment2.database.ShoppingCartDAOImp;
import com.brandon.assignment2.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "OrderControllerServlet", value = "/order")
public class OrderController extends HttpServlet {
    AddressDAOImp addressDAOImp = new AddressDAOImp();
    OrderDAOImp orderDAOImp = new OrderDAOImp();
    ShoppingCartDAOImp shoppingCartDAOImp = new ShoppingCartDAOImp();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            List<Order> orders = orderDAOImp.selectOrders(user.getId());
            request.getSession().setAttribute("orders", orders);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view-order.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("view-order.jsp");
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try{
            User user = (User) request.getSession().getAttribute("user");
            // Initialize var for address id
            int addressId = 0;
            if (request.getParameter("address0") != null){
                // List for addresses stored in session var
                List<?> addressList = (List<?>) request.getSession().getAttribute("addresses");

                for(int i = 0; i < addressList.size(); i++){
                    if (request.getParameter("address" + i) != null){
                        addressId = Integer.parseInt(request.getParameter("address" + i));
                    }
                }
            } else {
                    Address address = new Address();
                    address.setUserId(user.getId());
                    address.setStreet(request.getParameter("street"));
                    address.setCity(request.getParameter("city"));
                    address.setProvinceState(request.getParameter("province"));
                    address.setPostalCode(request.getParameter("postalCode"));
                    addressDAOImp.add(address);
                    addressId = addressDAOImp.select(user.getId()).get(0).getId();
            }
//            int orderID = orderDAOImp.addOrder(user.getId(), addressId);
            int orderID = orderDAOImp.addOrder(1, 1);
            List<?> cartItems = (List<?>) request.getSession().getAttribute("cart");
            List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
            for (Object item:
                    cartItems) {
                shoppingCartItems.add((ShoppingCartItem) item);
            };
            try{
                orderDAOImp.addOrderMap(orderID, shoppingCartItems);
                shoppingCartDAOImp.removeAll(user.getId());
            } catch (Exception e){
                throw new RuntimeException(e);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.include(request, response);
            dispatcher.forward(request, response);
            response.sendRedirect("main.jsp");
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}