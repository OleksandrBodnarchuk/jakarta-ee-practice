package pl.alex.appcontext;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = {"/private", "/public"})
public class NoteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Optional<Note> getNoteByType(HttpServletRequest request){
        String servletPath = request.getServletPath();
        String id = request.getParameter("id");
        if (servletPath.equals(Note.TYPE_PUBLIC))
    }
}
