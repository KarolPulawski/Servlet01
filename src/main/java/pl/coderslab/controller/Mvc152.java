package pl.coderslab.controller;

import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc152", urlPatterns = {"/Mvc152"})
public class Mvc152 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] authors = request.getParameterValues("author");
        String[] titles = request.getParameterValues("title");
        String[] isbns = request.getParameterValues("isbn");

        List<Book> books = null;
        HttpSession sess = request.getSession();

        try {
            books = (List<Book>) sess.getAttribute("books_list");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (books == null) {
            books = new ArrayList<>();
        }

        for(int i = 0; i < authors.length; i++) {
            Book book = new Book(titles[i], authors[i], isbns[i]);
            books.add(book);
        }
        sess.setAttribute("books_list", books);
        //doGet(request, response);
        response.sendRedirect("/mvc15show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/form152.jsp").forward(request, response);
    }
}
