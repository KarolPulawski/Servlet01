package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get3", urlPatterns = {"/get3"})
public class Get3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        int width = 5;
        int height = 10;

        try {
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        PrintWriter wr = response.getWriter();

        wr.println("<table>");
        for (int i = 1; i <= height; i++) {
            wr.println("<tr>");
            for(int j = 1; j <= width; j++) {
                wr.println("<td>");
                wr.println(" " + i*j + " ");
                wr.println("</td>");
            }
            wr.println("</tr>");
        }
        wr.println("</table>");
    }
}
