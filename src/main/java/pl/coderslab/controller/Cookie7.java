package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie7", urlPatterns = {"/rememberMe"})
public class Cookie7 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter wr = response.getWriter();

        String name = request.getParameter("name");

        wr.println("Hi " + name);

        if(request.getParameter("accept") != null) {
            CookieService.cookieAdd(response, "user_name", name);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter wr = response.getWriter();

        Cookie cookie = null;
        try {
            cookie = CookieService.getByName(request.getCookies(),"user_name");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(cookie != null) {
            String name = cookie.getValue();
            wr.println("Hi " + name + " | This data was read from cookie.");
        } else {
            wr.println("<form method=\"post\" action=\"/rememberMe\">\n" +
                    "        <label>\n" +
                    "            <input type = \"text\" name =\"name\" placeholder=\"name\">\n" +
                    "            <input type = \"checkbox\" name =\"accept\" value = \"1\">\n" +
                    "        </label>\n" +
                    "        <input type = \"submit\" value=\"Send\">\n" +
                    "    </form>");
        }



    }
}
