package pl.coderslab.controller;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MvcJdbc01", urlPatterns = {"/mvcJdbc01"})
public class MvcJdbc01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Book newBook = new Book();
            newBook.setAuthor(request.getParameter("author"));
            newBook.setIsbn(request.getParameter("isbn"));
            newBook.setTitle(request.getParameter("title"));

            BookDao.save(newBook);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = "Create table if not exists books (id int auto_increment Primary key, title varchar(255), author varchar(255), isbn varchar(50));";
        try {
            DbService.executeQuery(query, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/META-INF/form15.jsp").forward(request, response);

    }
}
