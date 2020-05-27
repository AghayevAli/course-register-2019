package service;

import dto.ComboDTO;
import dto.StudentDTO;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface RegisterService {
    List<ComboDTO> comboDatasFromDB(String dicKey) throws SQLException, NamingException;

    void addNewStudent(HttpServletRequest request, StudentDTO student) throws SQLException, NamingException;

    StudentDTO studentApproval(String confirmKey) throws SQLException, NamingException;

    List<StudentDTO> studentsFromDB() throws SQLException, NamingException;

    void removeUser(int id) throws SQLException, NamingException;

    StudentDTO logInUser(String email, String password) throws SQLException, NamingException;

    StudentDTO studentFromDB(int id) throws SQLException, NamingException;

    void updateStudent(StudentDTO updatedStudent) throws SQLException, NamingException;

    List<StudentDTO> moderatorsFromDB() throws SQLException, NamingException;

    void removeModerator(int id, int roleID) throws SQLException, NamingException;
}
