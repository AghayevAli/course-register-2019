package dao;

import dbConfig.DbConfig;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import dto.*;
import utilities.*;

import java.sql.*;
import java.util.*;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    /*-----------ComboBoxa bazadan melumatin gonderilib, doldurulmasi---------------*/
    public List<ComboDTO> comboDatasFromDB(String dicKey) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.COMBO_DATAS.getQuery());
        pst.setString(1, dicKey);
        ResultSet resultSet = pst.executeQuery();
        List<ComboDTO> comboDatas = new ArrayList<>();
        while (resultSet.next()) {
            comboDatas.add(new ComboDTO(resultSet.getInt(1), resultSet.getString("dic_val")));
        }
        return comboDatas;
    }

    /*-------------Telbenin bazaya elave edilmesi uchun gonderdiyi sorgu--------------*/
    @Override
    public void addNewStudent(HttpServletRequest request, StudentDTO student) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.ADD_STUDENT.getQuery(), new String[]{"id", "name"});
        String password = PasswordGenerator.passGenerator();
        pst.setString(1, student.getName());
        pst.setString(2, student.getSurname());
        pst.setString(3, student.getEmail());
        pst.setString(4, student.getGender());
        pst.setInt(5, student.getCombo().getId());
        pst.setInt(6, student.getPhoneNumber());
        pst.setString(7, password);
        pst.execute();
        int userId = -1;
        String userName = null;
        ResultSet generatedKeys = pst.getGeneratedKeys();
        if (generatedKeys.next()) {
            userId = generatedKeys.getInt(1);
            userName = generatedKeys.getString(2);
        }
        String confirmKey = UUID.randomUUID().toString();
        PreparedStatement pstConfirmKey = connection.prepareStatement(Query.ADD_CONFIRM_KEY.getQuery());
        pstConfirmKey.setInt(1, userId);
        pstConfirmKey.setString(2, confirmKey);
        pstConfirmKey.execute();

        SendMail.sendMail(request, student.getEmail(), userName, password, "Approval of the application", confirmKey);
    }

    /*-----------Telebenin tesdiqinden sonra gelen sorguya esasen bazaya elave olunmasi-----------*/
    @Override
    public StudentDTO studentApproval(String confirmKey) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.SELECT_STUDENT_BY_CONFIRM_KEY.getQuery());
        pst.setString(1, confirmKey);
        ResultSet resultSet = pst.executeQuery();
        int user_id = -1;
        if (resultSet.next()) {
            user_id = resultSet.getInt("user_id");
        }
        PreparedStatement pstApproval = connection.prepareStatement(Query.APPROVAL_STUDENT_APPEAL.getQuery());
        pstApproval.setInt(1, user_id);
        pstApproval.execute();
        PreparedStatement pstRole = connection.prepareStatement(Query.ADD_STUDENT_ROLE.getQuery());
        pstRole.setInt(1, user_id);
        pstRole.setInt(2, 3);
        pstRole.execute();
        PreparedStatement pstStudentName = connection.prepareStatement(Query.SELECT_STUDENT_NAME.getQuery());
        pstStudentName.setInt(1, user_id);
        ResultSet resultSet1 = pstStudentName.executeQuery();
        String studentName = null;
        String gender = null;
        StudentDTO nameGender = null;
        if (resultSet1.next()) {
            nameGender = new StudentDTO();
            nameGender.setName(resultSet1.getString("name"));
            nameGender.setGender(resultSet1.getString("gender"));
        }
        return nameGender;
    }

    /*-----------Cedvele telebelerin siyahisinin gonderilmesi---------*/
    @Override
    public List<StudentDTO> studentsFromDB() throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.SELECT_STUDENTS_FROM_DB.getQuery());
        ResultSet resultSet = pst.executeQuery();
        List<StudentDTO> students = new ArrayList<>();
        while (resultSet.next()) {
            ComboDTO combo = new ComboDTO();
            combo.setDic_val(resultSet.getString(7));
            students.add(new StudentDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), combo));
        }
        return students;
    }

    /*---------Cedvele moderatorlarin siyahisinin gonderlmesi------------*/
    @Override
    public List<StudentDTO> moderatorsFromDB() throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.SELECT_MODERATORS_FROM_DB.getQuery());
        ResultSet resultSet = pst.executeQuery();
        List<StudentDTO> moderators = new ArrayList<>();
        while (resultSet.next()) {
            RoleDTO role = new RoleDTO();
            role.setName(resultSet.getString(6));
            role.setId(resultSet.getInt(7));
            moderators.add(new StudentDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), role));
        }
        return moderators;
    }


    /*-------------------Telebenin cedvelden silinmesi-----------------------*/
    @Override
    public void removeStudent(int id) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.REMOVE_STUDENT.getQuery());
        pst.setInt(1, id);
        pst.execute();
    }

    /*-------------------Moderatorun cedvelden silinmesi-----------------------*/
    @Override
    public void removeModerator(int id, int roleID) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        System.out.println(id);
        System.out.println(roleID);
        PreparedStatement pst = connection.prepareStatement(Query.REMOVE_MODERATOR.getQuery());
        pst.setInt(1, id);
        pst.setInt(2, roleID);
        pst.execute();
    }

    /*---------------Telebenin log in olmasi----------------------*/
    @Override
    public StudentDTO logInUser(String email, String password) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.LOG_IN_STUDENT.getQuery());
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet resultSet = pst.executeQuery();
        StudentDTO student = null;
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            student = new StudentDTO(id, resultSet.getString(2), resultSet.getString(3));
            PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_STUDENT_ROLE.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resSet = preparedStatement.executeQuery();
            List<RoleDTO> roles = new ArrayList<>();
            while (resSet.next()) {
                roles.add(new RoleDTO(resSet.getInt(1), resSet.getString(2)));
            }
            student.setRoles(roles);
        }
        return student;
    }

    /*--------------Telebenin id ye esasen bazadan secilmesi-----------------*/
    @Override
    public StudentDTO studentFromDB(int id) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.SELECT_STUDENT_FROM_DB_BY_ID.getQuery());
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            ComboDTO combo = new ComboDTO();
            combo.setDic_val(resultSet.getString(7));
            combo.setId(resultSet.getInt(9));
            StudentDTO student = new StudentDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), combo);
            student.setGender(resultSet.getString(8));
            return student;
        }
        return null;
    }

    /*----------------Telebenin update olunmasi--------------*/
    @Override
    public void updateStudent(StudentDTO updatedStudent) throws SQLException, NamingException {
        Connection connection = DbConfig.open();
        PreparedStatement pst = connection.prepareStatement(Query.UPDATE_STUDENT.getQuery());
        pst.setString(1, updatedStudent.getName());
        pst.setString(2, updatedStudent.getSurname());
        pst.setString(3, updatedStudent.getEmail());
        pst.setString(4, updatedStudent.getGender());
        pst.setInt(5, updatedStudent.getCombo().getId());
        pst.setInt(6, updatedStudent.getPhoneNumber());
        pst.setInt(7, updatedStudent.getId());
        pst.execute();
        PreparedStatement preparedStatement = connection.prepareStatement(Query.ADD_STUDENT_ROLE.getQuery());
        preparedStatement.setInt(1, updatedStudent.getId());
        preparedStatement.setInt(2, updatedStudent.getRole().getId());
        preparedStatement.execute();
    }

}
