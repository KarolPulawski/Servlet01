package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sess03_Add", urlPatterns = {"/addToSession"})
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String key = request.getParameter("key");
        Integer value = null;

        try {
            value = Integer.parseInt(request.getParameter("value"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        sess.setAttribute(key, value);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        wr.println("<form action=\"/addToSession\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");
    }


}
