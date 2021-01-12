package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;
    private StudentDAO studentDAO;
    public void init() {
        studentDAO = new StudentDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        List<Student> ListStudent = studentDAO.selectAllStudent();
        request.setAttribute("ListStudent", ListStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.getStudentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.getStudentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int testScore = Integer.parseInt(request.getParameter("int"));
        Student newstudent = new Student(name, sex, testScore);
        studentDAO.insertStudentStore(newstudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int testScore = Integer.parseInt(request.getParameter("int"));
        Student book = new Student(id, name, sex, testScore);
        studentDAO.updateStudent(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        List<Student> ListStudent = studentDAO.selectAllStudent();
        request.setAttribute("ListStudent", ListStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}

