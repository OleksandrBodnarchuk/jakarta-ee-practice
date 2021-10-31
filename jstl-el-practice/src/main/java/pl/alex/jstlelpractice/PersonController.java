package pl.alex.jstlelpractice;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonController", value = "")
public class PersonController extends HttpServlet {

    @Override
    public void init() throws ServletException {
       getServletContext().setAttribute("people",new ArrayList<Person>());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        Person person = new Person(name, surname, age, Gender.valueOf(gender));
        List<Person> people = (List<Person>) getServletContext().getAttribute("people");
        people.add(person);
        request.getRequestDispatcher("/home.jsp").forward(request,response);
    }
}
