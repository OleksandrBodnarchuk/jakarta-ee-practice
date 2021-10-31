package pl.alex.appcontext;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/saveNote")
public class SaveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = createNewNote(request);
        saveNote(note, request);
        String noteUrl = NoteUtils.buildNoteUrl(note);

        request.setAttribute("noteUrl",noteUrl);
        request.getRequestDispatcher("/confirmation.jsp").forward(request,response);
    }

    private void saveNote(Note note, HttpServletRequest request) {
        if (note.getType().equals(Note.TYPE_PRIVATE)) {
            request.getSession().setAttribute(note.getId(), note);
        } else if (note.getType().equals(Note.TYPE_PUBLIC)) {
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute(note.getId(), note);
        }
    }

    private Note createNewNote(HttpServletRequest request) {
        String noteId = request.getParameter("noteId");
        String noteType = request.getParameter("noteType");
        String noteContent = request.getParameter("noteContent");
        return new Note(noteId, noteContent, noteType);
    }
}
