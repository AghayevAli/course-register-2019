<%@ page import="java.util.List" %>
<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<StudentDTO> moderators = (List<StudentDTO>) request.getAttribute("moderators");
    for (StudentDTO moderator : moderators) {
%>
<tr>
    <td><%=moderator.getRowId()%>
    </td>
    <td><%=moderator.getName()%>
    </td>
    <td><%=moderator.getSurname()%>
    </td>
    <td><%=moderator.getEmail()%>
    </td>
    <td><%=moderator.getRole().getName()%>
    </td>
    <td>
        <div style="display: flex;justify-content: flex-end">
            <button onclick="editStudent(<%=moderator.getId()%>)" id="userEditButton">
                <i class="fas fa-user-edit"></i>
            </button>
            <button onclick="removeModerator(<%=moderator.getId()%>,<%=moderator.getRole().getId()%>)"
                    class="deleteButton" data-toggle="modal"
                    data-target="#moderatorModal">
                <i class="fas fa-user-times"></i>
            </button>
        </div>
    </td>
</tr>
<%}%>