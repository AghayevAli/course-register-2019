<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<style>
    label, input {
        display: block;
    }

    input.text {
        margin-bottom: 12px;
        width: 95%;
        padding: .4em;
    }

    fieldset {
        padding: 0;
        border: 0;
        margin-top: 25px;
    }

    h1 {
        font-size: 1.2em;
        margin: .6em 0;
    }

    div#users-contain {
        width: 350px;
        margin: 20px 0;
    }

    div#users-contain table {
        margin: 1em 0;
        border-collapse: collapse;
        width: 100%;
    }

    div#users-contain table td, div#users-contain table th {
        border: 1px solid #eee;
        padding: .6em 10px;
        text-align: left;
    }

    .ui-dialog .ui-state-error {
        padding: .3em;
    }

    .validateTips {
        border: 1px solid transparent;
        padding: 0.3em;
    }

</style>
<%StudentDTO student = (StudentDTO) request.getAttribute("editStudent");%>
<form>
    <fieldset>
        <input id="editStudentID" value="<%=student.getId()%>" style="display: none">
        <label for="editName"><i class="fas fa-user-circle"></i></label> <input id="editName"
                                                                                class="text ui-widget-content ui-corner-all"
                                                                                type="text" placeholder="Ad"
                                                                                value="<%=student.getName()%>"
                                                                                autocomplete="off">
        <label for="editSurname"><i class="far fa-user-circle"></i></label> <input id="editSurname"
                                                                                   class="text ui-widget-content ui-corner-all"
                                                                                   type="text" placeholder="Soyad"
                                                                                   value="<%=student.getSurname()%>"
                                                                                   autocomplete="off">
        <label for="editEmail"><i class="fas fa-envelope"></i></label> <input id="editEmail"
                                                                              class="text ui-widget-content ui-corner-all"
                                                                              type="text"
                                                                              placeholder="e-mail"
                                                                              value="<%=student.getEmail()%>"
                                                                              autocomplete="off">
        <label for="editPhoneNumber"><i class="fas fa-phone"></i></label> <input id="editPhoneNumber"
                                                                                 class="text ui-widget-content ui-corner-all"
                                                                                 type="number"
                                                                                 placeholder="əlaqə nömrəsi"
                                                                                 value="<%=student.getPhoneNumber()%>"
                                                                                 autocomplete="off">
        <%if ("Male".equalsIgnoreCase(student.getGender())) { %>
        <input class="radio-inline myRadio" type="radio" name="radioBtn" value="Male" checked="checked"> <i
            class="fas fa-male"></i> Kişi
        <input class="radio-inline myRadio" type="radio" name="radioBtn" value="Female"> <i class="fas fa-female"></i>
        Qadın
        <%} else {%>
        <input class="radio-inline myRadio" type="radio" name="radioBtn" value="Male" checked="checked"> <i
            class="fas fa-male"></i> Kişi
        <input class="radio-inline myRadio" type="radio" name="radioBtn" value="Female" checked="checked"> <i
            class="fas fa-female"></i>
        Qadın
        <%}%>
        <br/>
        <select id="editLessonTypeCombo" style="margin-top: 9px">
            <script>
                loadCombo('lessonType', <%=student.getCombo().getId()%>);
            </script>
        </select>
        <br/>
        <select id="positionCombo" style="margin-top: 9px">
            <script>
                loadCombo('position');
            </script>
        </select>
        <!-- Allow form submission with keyboard without duplicating the dialog button -->
        <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
</form>
<div id="loading" class="lds-ring"></div>




