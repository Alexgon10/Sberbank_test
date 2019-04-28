package web_app.controller;
import web_app.controller.Person;
import web_app.Database_controller.QueryDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Person person = QueryDB.selectOne(id);
            if(person!=null) {
                request.setAttribute("person",person);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
           }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstname = request.getParameter("firstname");
            String gender = request.getParameter("gender");
            String middlename = request.getParameter("middlename");
            String lastname = request.getParameter("lastname");
            String age = request.getParameter("age");
            Person product = new Person(id, firstname,middlename,lastname,age,gender);
            QueryDB.update(product);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}