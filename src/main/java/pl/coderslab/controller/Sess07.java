package pl.coderslab.controller;

import pl.coderslab.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Sess07", urlPatterns = {"/sess07"})
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        Country country = (Country) sess.getAttribute("list");

        String capitalInput = request.getParameter("name");

        if(capitalInput.equals(country.getCapital())) {
            wr.println("TEST");
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();
        List<Country> list = (List<Country>) sess.getAttribute("list");

        if(list == null) {
            list = new ArrayList<>();
            list.add(new Country("Germany","Berlin"));
            list.add(new Country("Czech Repubic","Praga"));
            list.add(new Country("Slovakia","Bratyslava"));
            list.add(new Country("Ukraine","Kijov"));
            list.add(new Country("Lituania","Wilno"));
            list.add(new Country("Belarus","Minsk"));
            list.add(new Country("Russia","Moscow"));
        }

        wr.println("    <form method=\"post\" action=\"/sess07\">\n" +
                "        <label>\n" +
                "            Please type capital of the following country "+list.get(0).getCountry()+"\n"+
                "            <input type = \"text\" name =\"name\" placeholder=\"capital\">\n" +
                "        </label>\n" +
                "        <input type = \"submit\" value=\"Send\">\n" +
                "    </form>");

    }
}
