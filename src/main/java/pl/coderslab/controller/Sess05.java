package pl.coderslab.controller;

import pl.coderslab.service.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sess05", urlPatterns = {"/sess05"})
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        int result = (int) sess.getAttribute("captcha_result");
        Integer inputResult = null;
        try {
             inputResult = Integer.parseInt(request.getParameter("result"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if(result == inputResult) wr.println("<h3>Correct result</h3>");
        else wr.println("<h3>Incorrect result</h3>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        int firstNumber = MathService.generateRandomNumber(0,100);
        int secondNumber = MathService.generateRandomNumber(0, 100);
        int result = firstNumber + secondNumber;

        sess.setAttribute("captcha_result", result);

        wr.println("        <form method=\"post\" action=\"/sess05\">\n" +
                "            <label>\n" +
                "                <input type = \"text\" name =\"name\" placeholder=\"name\">\n" +
                "                <input type = \"text\" name =\"surname\" placeholder=\"surname\">\n" +
                "                <input type = \"text\" name =\"email\" placeholder=\"email\">\n" +
                "                 </br>Please type valid result: " + firstNumber + " + " + secondNumber +
                "                <input type = \"number\" name =\"result\" placeholder=\"result\">\n" +
                "                </br>" +
                "                <input type = \"submit\" value=\"Send\">\n" +
                "            </label>\n" +
                "        </form> ");

    }
}
