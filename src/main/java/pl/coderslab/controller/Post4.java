package pl.coderslab.controller;

import pl.coderslab.service.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Post4", urlPatterns = "/post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter wr = response.getWriter();
        String[] params = request.getParameterValues("numbers");

        List<Double> result = MathService.receiveDouble(params);

        for(Double number : result) {
            wr.println("</br>");
            wr.println(number);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();

        Random random = new Random();
        int randNumber = random.nextInt(5) + 5;

        wr.println("<form action='/post4' method='post'>");
        for(int i = 0; i <= randNumber; i++) {
            wr.println("<input name='numbers'/><br/>");
        }
        wr.println("<input type='submit' value = 'SUBMIT' />");
        wr.println("</form>");
    }
}
