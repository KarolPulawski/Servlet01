package pl.coderslab.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieService {

    /**
     * Get cookie object by name or null if not found
     * @param cookies
     * @param cookieName
     * @return Cookie or null if not found
     */
    public static Cookie getByName(Cookie[] cookies, String cookieName) {
        try {
            for(Cookie c : cookies) {
                if(c.getName().equals(cookieName)) {
                    return c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue, int maxAge, String path) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

}
