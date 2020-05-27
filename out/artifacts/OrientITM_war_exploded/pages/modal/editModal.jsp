<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="modal fade" id="editModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 class="modal-title">Tələbənin məlumatlarının dəyişdirilməsi</h2>
                </div>
                <div class="modal-body">
                    <p> Tələbənin məlumatlarını dəyişmək istədiyinizə əminsiniz?</p>
                </div>
                <div class="modal-footer">
                    <button onclick="updateStudent()" type="button" style="background-color: red;color: white"
                            class="btn btn-default" data-dismiss="modal">Bəli
                    </button>
                    <button type="button" style="background-color: #aaaaaa;color: white" class="btn btn-default"
                            data-dismiss="modal">İmtina et
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
