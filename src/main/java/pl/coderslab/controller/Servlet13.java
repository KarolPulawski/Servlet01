package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet(name = "Servlet13", urlPatterns = {"/servlet13"})
public class Servlet13 extends HttpServlet {

    public LocalDateTime initDateTime;

    @Override
    public void init() throws ServletException {
        super.init();
        this.initDateTime = LocalDateTime.now();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter()
                .append("Hello from server: ")
                .append(LocalDateTime.now().toString())
                .append("\nServer initialized at: ")
                .append(initDateTime.toString());
    }
}
