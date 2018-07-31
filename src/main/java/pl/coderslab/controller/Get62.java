package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = {"/Get62"})
public class Get62 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();

        Random random = new Random();


        String year = request.getParameter("year");

        for(int i = 0; i < 5; i++) {
            int rand = random.nextInt(20) - 10;
            String randString = String.valueOf(rand);
            wr.println("</br>");
            wr.println("<a href='http://localhost:8080/Get63?year=" +
                    year +
                    "&mix=" +
                    randString +
                    "'> Rok " +
                    year +
                    ", mix " +
                    randString +
                    " </a>");
        }
    }
}
