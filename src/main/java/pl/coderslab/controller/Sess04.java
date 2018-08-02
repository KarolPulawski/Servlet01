package pl.coderslab.controller;

import pl.coderslab.service.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess04", urlPatterns = {"/sess04"})
public class Sess04 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        List<Product> products = null;

        try {
            products = (List<Product>) sess.getAttribute("products_list");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(products == null) {
            products = new ArrayList<>();
        }

        try {
            String name = request.getParameter("name");
            Integer amount = Integer.parseInt(request.getParameter("amount"));
            Double price = Double.parseDouble(request.getParameter("price"));

            Product product = new Product(name, amount, price);
            products.add(product);
            sess.setAttribute("products_list", products);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        List<Product> products = (List<Product>) sess.getAttribute("products_list");

        for(Product prod : products) {
            wr.println("<p>");
            wr.println(prod.toString());
            wr.println("</p>");
        }

    }
}
