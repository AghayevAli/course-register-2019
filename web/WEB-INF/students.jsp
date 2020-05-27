<%@ page import="java.util.List" %>
<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<StudentDTO> students = (List<StudentDTO>) request.getAttribute("students");
    for (StudentDTO student : students) {%>
<tr>
    <td><%=student.getRowId()%>
    </td>
    <td><%=student.getName()%>
    </td>
    <td><%=student.getSurname()%>
    </td>
    <td><%=student.getEmail()%>
    </td>
    <td><%=student.getPhoneNumber()%>
    </td>
    <td><%=student.getCombo().getDic_val()%>
    </td>
    <td>
        <div style="display: flex;justify-content: flex-end">
            <button onclick="editStudent(<%=student.getId()%>)" id="userEditButton">
                <i class="fas fa-user-edit"></i>
            </button>
            <button onclick="removeUser(<%=student.getId()%>)" class="deleteButton" data-toggle="modal"
                    data-target="#myModal">
                <i class="fas fa-user-times"></i>
            </button>
        </div>
    </td>
</tr>
<%}%>