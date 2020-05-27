package service;

import dao.RegisterDao;
import dao.RegisterDaoImpl;
import dto.ComboDTO;
import dto.StudentDTO;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {
    private RegisterDao registerDao = new RegisterDaoImpl();

    @Override
    public List<ComboDTO> comboDatasFromDB(String dicKey) throws SQLException, NamingException {
        return registerDao.comboDatasFromDB(dicKey);
    }

    @Override
    public void addNewStudent(HttpServletRequest request, StudentDTO student) throws SQLException, NamingException {
        registerDao.addNewStudent(request, student);
    }

    @Override
    public StudentDTO studentApproval(String confirmKey) throws SQLException, NamingException {
        return registerDao.studentApproval(confirmKey);
    }

    @Override
    public List<StudentDTO> studentsFromDB() throws SQLException, NamingException {
        return registerDao.studentsFromDB();
    }

    @Override
    public void removeUser(int id) throws SQLException, NamingException {
        registerDao.removeStudent(id);
    }

    @Override
    public StudentDTO logInUser(String email, String password) throws SQLException, NamingException {
        return registerDao.logInUser(email, password);
    }

    @Override
    public StudentDTO studentFromDB(int id) throws SQLException, NamingException {
        return registerDao.studentFromDB(id);
    }

    @Override
    public void updateStudent(StudentDTO updatedStudent) throws SQLException, NamingException {
        registerDao.updateStudent(updatedStudent);
    }

    @Override
    public List<StudentDTO> moderatorsFromDB() throws SQLException, NamingException {
        return registerDao.moderatorsFromDB();
    }

    @Override
    public void removeModerator(int id, int roleID) throws SQLException, NamingException {
        registerDao.removeModerator(id, roleID);
    }
}
