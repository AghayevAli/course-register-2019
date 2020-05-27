package Controller;

import dbConfig.DbConfig;
import dto.ComboDTO;
import dto.RoleDTO;
import dto.StudentDTO;
import service.RegisterService;
import service.RegisterServiceImpl;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerServlet extends javax.servlet.http.HttpServlet {
    private RegisterService registerService = new RegisterServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        manualRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        manualRequest(request, response);
    }

    private void manualRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        String path = "";
        try {
            /*-------------------------Combonun doldurulmasi---------------------*/
            if ("comboDatas".equalsIgnoreCase(action)) {
                path = "WEB-INF/combos.jsp";
                String dicKey = request.getParameter("dicKey");
                List<ComboDTO> comboDatasList = registerService.comboDatasFromDB(dicKey);
                Map<String, List<ComboDTO>> comboDatas = new HashMap<>();
                comboDatas.put(dicKey, comboDatasList);
                request.setAttribute("comboDatas", comboDatas);
                /*----------------Telebenin muracietinin bazaya yazilmasi---------------*/
            } else if ("addStudent".equalsIgnoreCase(action)) {
                StudentDTO student = new StudentDTO();
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
                String gender = request.getParameter("gender");
                int lessonType = Integer.parseInt(request.getParameter("lessonType"));
                ComboDTO combo = new ComboDTO();
                student.setName(name);
                student.setSurname(surname);
                student.setEmail(email);
                student.setPhoneNumber(phoneNumber);
                student.setGender(gender);
                combo.setId(lessonType);
                student.setCombo(combo);
                registerService.addNewStudent(request, student);
                /*--------------Telebenin muracietini mail vasitesi ile tesdiqlemesi--------------*/
            } else if ("confirm".equalsIgnoreCase(action)) {
                path = "index.jsp";
                String confirmKey = request.getParameter("confirmKey");
                StudentDTO studentName = registerService.studentApproval(confirmKey);
                request.setAttribute("studentName", studentName);
                /*-----------Telebelerin adlarinin cedvele cixarilmasi-----------------*/
            } else if ("studentList".equalsIgnoreCase(action)) {
                path = "WEB-INF/students.jsp";
                List<StudentDTO> students = registerService.studentsFromDB();
                request.setAttribute("students", students);
                /*------------Moderatorlarin melumatlarinin cedvele cixarilmasi-----------*/
            } else if ("moderatorsList".equalsIgnoreCase(action)) {
                path = "WEB-INF/moderators.jsp";
                List<StudentDTO> moderators = registerService.moderatorsFromDB();
                request.setAttribute("moderators", moderators);
                /*-------------Id ye esasen cedvelden telebenin secilmesi---------------*/
            } else if ("editStudent".equalsIgnoreCase(action)) {
                path = "WEB-INF/editStudent.jsp";
                int id = Integer.parseInt(request.getParameter("id"));
                StudentDTO student = registerService.studentFromDB(id);
                request.setAttribute("editStudent", student);
                /*-----------Telebelerin cedvelden silinmesi-----------------*/
            } else if ("removeStudent".equalsIgnoreCase(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                registerService.removeUser(id);
                /*------------Moderatorun cedvelden silinmesi------------------*/
            } else if ("removeModerator".equalsIgnoreCase(action)) {
                System.out.println("salamun aleykum");
                int id = Integer.parseInt(request.getParameter("id"));
                int roleID = Integer.parseInt(request.getParameter("roleId"));
                registerService.removeModerator(id, roleID);

                /*-----------Login-----------------*/
            } else if ("logInUser".equalsIgnoreCase(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                HttpSession session = request.getSession(true);
                StudentDTO student = registerService.logInUser(email, password);
                if (student != null) {
                    session.setAttribute("student", student);
                } else {
                    session.setAttribute("errorMessage", "! email və ya şifrə yanlış qeyd olunub");
                }
            } else if ("logOut".equalsIgnoreCase(action)) {
                request.getSession(true).invalidate();
                /*-------------Telebenin melumatlarinin update olunmasi----------------*/
            } else if ("updateStudent".equalsIgnoreCase(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
                String gender = request.getParameter("gender");
                int lessonType = Integer.parseInt(request.getParameter("lessonType"));
                int position = Integer.parseInt(request.getParameter("position"));
                ComboDTO editedCombo = new ComboDTO();
                RoleDTO editedRole = new RoleDTO();
                editedCombo.setId(lessonType);
                editedRole.setId(position);
                StudentDTO updatedStudent = new StudentDTO(id, name, surname, email, phoneNumber, gender, editedCombo);
                updatedStudent.setRole(editedRole);
                registerService.updateStudent(updatedStudent);
            }
        } catch (SQLException | NamingException e) {
            System.out.println("exception");
            e.printStackTrace();
        } finally {
            try {
                DbConfig.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
