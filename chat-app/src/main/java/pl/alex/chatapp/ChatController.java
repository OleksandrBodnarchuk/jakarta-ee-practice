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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/chat.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessage(request);
        addMessageToHistory(message,request);
        request.getRequestDispatcher("/chat.jsp").forward(request,response);
    }

    private void addMessageToHistory(Message message, HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        List<Message> messages = (List<Message>) context.getAttribute("chat");
        if (messages==null){
            messages = new ArrayList<>();
        }
        messages.add(message);
        context.setAttribute("chat",messages);
    }

    private Message createMessage(HttpServletRequest request) {
        String text = request.getParameter("message");
        String author = request.getParameter("author");
        return new Message(author,text);
    }


}
