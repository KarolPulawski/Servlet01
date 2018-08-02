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

@WebServlet(name = "Mvc15", urlPatterns = {"/Mvc15"})
public class Mvc15 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");

        List<Book> books = null;
        HttpSession sess = request.getSession();

        try{
            books = (List<Book>) sess.getAttribute("books_list");
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(books == null) {
            books = new ArrayList<>();
        }

        Book book = new Book(title, author, isbn);
        books.add(book);
        sess.setAttribute("books_list", books);
        //doGet(request, response);
        response.sendRedirect("/mvc15show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/form15.jsp").forward(request, response);
    }
}
