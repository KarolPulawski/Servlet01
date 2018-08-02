package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie4Show", urlPatterns = {"/cookie4show"})
public class Cookie4Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter wr = response.getWriter();

        try {
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies) {
                if (c == null) {
                    wr.println("Cookie null");
                } else {
                    wr.print("<p>");
                    wr.print(c.getName());
                    wr.print(" -> ");
                    wr.println("<a href = \"http://localhost:8080/cookie4del?name=" + c.getName() + "\">delete cookie </a>");
                    wr.println("</p>");
                }
            }
        } catch (Exception e) {
            wr.println("Cookies are empty!");
        }
    }
}
