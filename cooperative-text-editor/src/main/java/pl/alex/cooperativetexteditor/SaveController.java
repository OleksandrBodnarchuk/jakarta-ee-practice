package pl.alex.cooperativetexteditor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SaveController" , value = "")
public class SaveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Object text = context.getAttribute("context");
        System.out.println(text);
        forwardRequestContext(request, response, text);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("context");
        ServletContext context = getServletContext();
        context.setAttribute("context",text);
        System.out.println(text);
        forwardRequestContext(request, response, text);
    }

    private void forwardRequestContext(HttpServletRequest request, HttpServletResponse response, Object text) throws ServletException, IOException {
        request.setAttribute("context", text !=null ? text :"");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}