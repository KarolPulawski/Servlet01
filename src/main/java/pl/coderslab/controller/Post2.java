package pl.coderslab.controller;

import pl.coderslab.service.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Post2", urlPatterns = {"/post2"})
public class Post2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String text = request.getParameter("text");
        if(request.getParameter("accept") == null) {
            text = TextService.censureText(text);
        }

        response.getWriter().append(text);

//        Map<String, String[]> params = request.getParameterMap();
//        Set<String> keys = params.keySet();
//        for(String key : keys) {
//            System.out.println(key);
//            System.out.println(Arrays.toString(params.get(key)));
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
