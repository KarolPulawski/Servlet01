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

@WebServlet(name = "Sess06", urlPatterns = {"/sess06"})
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        int firstNumber = (int) sess.getAttribute("number_first");
        int secondNumber = (int) sess.getAttribute("number_second");

        Integer resultAddPost = null;
        Integer resultSubPost = null;
        Integer resultMulPost = null;

        try {
            resultAddPost = Integer.parseInt(request.getParameter("sum"));
            resultSubPost = Integer.parseInt(request.getParameter("subtract"));
            resultMulPost = Integer.parseInt(request.getParameter("multi"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int resultAdd = firstNumber + secondNumber;
        int resultSub = firstNumber - secondNumber;
        int resultMul = firstNumber * secondNumber;

        wr.println("<p>"+firstNumber+" + "+secondNumber+" = " + resultAdd);
        if(resultAdd == resultAddPost) wr.println(" CORRECT ");
        else wr.println(" INCORRECT ");
        wr.println("</p>");

        wr.println("<p>"+firstNumber+" - "+secondNumber+" = " + resultSub);
        if(resultSub == resultSubPost) wr.println(" CORRECT ");
        else wr.println(" INCORRECT ");
        wr.println("</p>");

        wr.println("<p>"+firstNumber+" * "+secondNumber+" = " + resultMul);
        if(resultMul == resultMulPost) wr.println(" CORRECT ");
        else wr.println(" INCORRECT ");
        wr.println("</p>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstNumber = MathService.generateRandomNumber(20, 1000);
        int secondNumber = MathService.generateRandomNumber(20, 1000);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        sess.setAttribute("number_first",firstNumber);
        sess.setAttribute("number_second",secondNumber);

        wr.println("    <form method=\"post\" action=\"/sess06\">\n" +
                "        <label>\n" +
                + firstNumber + " + " + secondNumber +
                "            <input type = \"text\" name =\"sum\" placeholder=\"sum result\">\n" +
                "            </br>" +
                + firstNumber + " - " + secondNumber +
                "            <input type = \"text\" name =\"subtract\" placeholder=\"subtract result\">\n" +
                "            </br>" +
                + firstNumber + " * " + secondNumber +
                "            <input type = \"text\" name =\"multi\" placeholder=\"multiply result\">\n" +
                "            </br>" +
                "        </label>\n" +
                "        <input type = \"submit\" value=\"Send\">\n" +
                "    </form>");
    }
}
