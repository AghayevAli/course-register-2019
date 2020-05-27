<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.ComboDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%
    Map<String, List<ComboDTO>> comboDatas = (Map<String, List<ComboDTO>>) request.getAttribute("comboDatas");
    Set<Map.Entry<String, List<ComboDTO>>> entries = comboDatas.entrySet();
    for (Map.Entry<String, List<ComboDTO>> comboData : entries) {
        List<ComboDTO> comboDataList = comboData.getValue();
        if ("lessonType".equalsIgnoreCase(comboData.getKey())) {%>
<option style="display: none">Proqramı seçin</option>
<%
    for (ComboDTO data : comboDataList) {%>
<option value="<%=data.getId()%>"><%=data.getDic_val()%>
</option>
<%
    }
} else if ("position".equalsIgnoreCase(comboData.getKey())) {%>
<option style="display: none">Choose position</option>
<%
    int i = 0;
    for (ComboDTO data : comboDataList) {
        i = i + 1; %>
<option value="<%=i%>"><%=data.getDic_val()%>
</option>
<% }
}
}%>
