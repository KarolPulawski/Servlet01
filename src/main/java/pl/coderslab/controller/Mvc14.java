package pl.coderslab.controller;

import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc14", urlPatterns = {"/mvc14"})
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] authors = request.getParameterValues("author");
        String[] titiles = request.getParameterValues("title");
        String[] isbns = request.getParameterValues("isbn");

        List<Book> books = new ArrayList<>();

        for(int i = 0; i < authors.length; i++) {
            Book book = new Book(titiles[i], authors[i], isbns[i]);
            books.add(book);
        }

        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/META-INF/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/form.jsp").forward(request,response);
    }
}
