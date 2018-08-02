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

@WebServlet(name = "Cookie52", urlPatterns = {"/cookie52"})
public class Cookie52 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        Cookie cookie = null;
        try {
            cookie = CookieService.getByName(request.getCookies(), "enter_site");
            if(cookie.getValue().equals("entered")) {
                wr.print("<p>");
                wr.println("Welcome at site Cookie52!");
                wr.println("</p>");
                CookieService.deleteCookie(response, "enter_site");
            }
        } catch (Exception e) {
            wr.print("<p>");
            wr.println("You must first visit site Cookie51!!");
            wr.println("<a href = http://localhost:8080/cookie51> Back to Cookie51</a>");
            wr.println("</p>");
        }

    }
}
