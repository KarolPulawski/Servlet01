package pl.coderslab.controller;

import pl.coderslab.service.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post3", urlPatterns = "/post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter wr = response.getWriter();

        try {
            Double a = Double.parseDouble(request.getParameter("a_number"));
            Double b = Double.parseDouble(request.getParameter("b_number"));
            Double c = Double.parseDouble(request.getParameter("c_number"));
            wr.println(MathService.equation(a,b,c));
        } catch (NumberFormatException e) {
            wr.println("Minimum one parameter is empty, please type again.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
