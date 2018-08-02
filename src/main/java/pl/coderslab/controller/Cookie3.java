package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        try {
            int cookieAge = Integer.parseInt(request.getParameter("age"));
            CookieService.cookieAdd(response,   request.getParameter("key"),
                                                request.getParameter("value"),
                                                cookieAge * 3600);
            wr.append("Cookie was added.");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            wr.append("Cookie was not created.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
