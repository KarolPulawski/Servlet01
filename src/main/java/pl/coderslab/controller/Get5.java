package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get5", urlPatterns = {"/Get5"})
public class Get5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        Map<String, String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();

        wr.println("<ul style = \"list-style-type: none\">");
        for(String key : keys) {
            wr.println("<li>");
            wr.println(key + " :");
            wr.println("</li>");
            for(String value : params.get(key)) {
                wr.println("<li>");
                wr.println("\t- " + value);
                wr.println("</li>");
            }
        }
        wr.println("</ul");
    }
}
