package pl.alex.chatapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChatController", urlPatterns = {"","/chat"})

public class ChatController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("chat",new ArrayList<Message>());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/chat.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("message");
        String author = request.getParameter("author");
        Message message = new Message(author,text);
        List<Message> messages = (List<Message>) getServletContext().getAttribute("chat");
        messages.add(message);
        request.getRequestDispatcher("/chat.jsp").forward(request,response);
    }


}
