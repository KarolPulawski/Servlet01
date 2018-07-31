package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get63", urlPatterns = {"/Get63"})
public class Get63 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();

        String paramYear = request.getParameter("year");
        String paramMix = request.getParameter("mix");

        try {
            int year = Integer.parseInt(paramYear);
            int mix = Integer.parseInt(paramMix);
            int result = year + mix;
            wr.append("Rok: " + result);
        } catch(Exception e) {

        }
    }
}
