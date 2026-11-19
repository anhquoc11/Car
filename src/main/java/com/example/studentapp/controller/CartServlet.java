package com.example.studentapp.controller;

import com.example.studentapp.entity.Cart;
import com.example.studentapp.entity.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if ("update".equalsIgnoreCase(action)) {
            String description = request.getParameter("description");
            String quantityStr = request.getParameter("quantity");
            if (description != null && quantityStr != null) {
                int quantity = Integer.parseInt(quantityStr);
                cart.updateQuantity(description, quantity);
            }

        } else if ("remove".equalsIgnoreCase(action)) {
            String description = request.getParameter("description");
            if (description != null) {
                cart.removeItem(description);
            }
        } else {
            String description = request.getParameter("description");
            String priceStr = request.getParameter("price");

            if (description != null && priceStr != null) {
                double price = Double.parseDouble(priceStr);
                Item item = new Item(description, price, 1);
                cart.addItem(item);
            }
        }

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
