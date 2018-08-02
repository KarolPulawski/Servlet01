package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie4Del", urlPatterns = {"/cookie4del"})
public class Cookie4Del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        String cookieName = request.getParameter("name");
        try {
            CookieService.deleteCookie(response, cookieName);
            wr.println("Cookie was deleted.");
        } catch (Exception e) {
            wr.println("Cookie could not be deleted.");
        }
    }
}
