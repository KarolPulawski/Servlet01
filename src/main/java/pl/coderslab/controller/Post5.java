package pl.coderslab.controller;

import pl.coderslab.service.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Post5", urlPatterns = {"/post5"})
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();

        String typeConvertion = request.getParameter("convertionType");
        try {
            Double temp = Double.parseDouble(request.getParameter("degrees"));
            wr.print("Temperature is: ");
            if(typeConvertion.equals("celcToFahr")) {
                wr.print(MathService.tempartureCelToFahr(temp));
                wr.print(" [F]");
            }
            else if (typeConvertion.equals("FahrToCelc")) {
                wr.print(MathService.tempartureFahrToCelc(temp));
                wr.print(" [C]");
            }
        } catch (NumberFormatException e) {
            wr.println("Type value is not a number!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
