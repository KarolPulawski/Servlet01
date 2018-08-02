package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie51", urlPatterns = {"/cookie51"})
public class Cookie51 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter wr = response.getWriter();

        CookieService.cookieAdd(response, "enter_site", "entered");

        wr.print("<p>");
        wr.print("Link to servlet cookie52");
        wr.print(" -> ");
        wr.println("<a href = http://localhost:8080/cookie52> Enter Cookie52</a>");
        wr.println("</p>");
    }
}
