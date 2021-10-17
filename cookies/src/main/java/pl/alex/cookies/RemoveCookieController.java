package pl.alex.cookies;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/remove")
public class RemoveCookieController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookieToBeRemoved = new Cookie("visits", "");
        cookieToBeRemoved.setMaxAge(0);
        response.addCookie(cookieToBeRemoved);
        String cookieMessage = "Cookie removed";
        request.setAttribute("cookieMessage", cookieMessage);
        request.getRequestDispatcher("/removeConfirmation.jsp").forward(request, response);
    }
}
