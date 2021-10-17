package pl.alex.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/visits")
public class VisitsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Optional<Cookie> optionalCookie = getCookieByName(request, "visits");
        Integer numberOfVisits = optionalCookie.map(Cookie::getValue).map(Integer::parseInt).orElse(0);
        numberOfVisits++;
        Cookie cookie = new Cookie("visits", String.valueOf(numberOfVisits));
        response.addCookie(cookie);
        request.setAttribute("numberOfVisits", numberOfVisits);
        request.getRequestDispatcher("/visits.jsp").forward(request, response);
    }

    private Optional<Cookie> getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return Optional.empty();
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)){
                    return Optional.of(cookie);
                }
            }
        }

        return Optional.empty();
    }

}