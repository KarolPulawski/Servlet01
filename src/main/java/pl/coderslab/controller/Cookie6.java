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

@WebServlet(name = "Cookie6", urlPatterns = {"/cookie6"})
public class Cookie6 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color_text = request.getParameter("color_text");
        String color_background = request.getParameter("color_background");
        PrintWriter wr = response.getWriter();

        String colorTextFromCookie = null;
        String colorBackgroundFromCookie = null;

        try {
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies) {
                if(c.getName().equals("color_text")) {
                    colorTextFromCookie = c.getValue();
                } else if(c.getName().equals("color_background")) {
                    colorBackgroundFromCookie = c.getValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (color_text == null || color_text == "" || color_background == null || color_background == "") {
            if (colorTextFromCookie == null || colorBackgroundFromCookie == null) {
                response.sendRedirect("/index_6.html");
            } else {
                color_text = colorTextFromCookie;
                color_background = colorBackgroundFromCookie;
            }
        }

        CookieService.cookieAdd(response, "color_text", color_text);
        CookieService.cookieAdd(response, "color_background", color_background);
        wr.println("<p style='color: " + color_text + "; background-color: " + color_background + "'>");
        wr.println("Your text has " + color_text + " color and background has: " + color_background + " color.");
        wr.println("</p>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter wr = response.getWriter();

        try {
            Cookie text = CookieService.getByName(request.getCookies(),"color_text");
            Cookie background = CookieService.getByName(request.getCookies(),"color_background");

            String color_text = text.getValue();
            String color_background = background.getValue();

            wr.println("Cookies has stored following values of text color: ");
            wr.println(color_text);
            wr.println(" background color: ");
            wr.println(color_background);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
