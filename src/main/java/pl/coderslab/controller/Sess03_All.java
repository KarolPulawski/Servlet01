package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Sess03_All", urlPatterns = {"/showAllSession"})
public class Sess03_All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        HttpSession sess = request.getSession();

        Enumeration<String> attributeList = sess.getAttributeNames();
        while(attributeList.hasMoreElements()) {
            String att = attributeList.nextElement();
            Integer value = null;
            try {
                value = (Integer) sess.getAttribute(att);
            } catch (Exception e) {
                e.printStackTrace();
            }
            wr.println("<br>");
            wr.println(att + " | " + value);
            wr.println("</br>");
        }
    }
}
