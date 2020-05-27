<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var id;

    function removeUser(userId) {
        id = userId;
    }
</script>
<div class="container">
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 class="modal-title">Tələbəni siyahıdan silmək</h2>
                </div>
                <div class="modal-body">
                    <p> Tələbənin məlumatlarının tamamilə siyahıdan silmək istədiyinizə əminsiniz?</p>
                </div>
                <div class="modal-footer">
                    <button onclick="removeUserFromDB()" type="button" style="background-color: red;color: white"
                            class="btn btn-default" data-dismiss="modal">Bəli
                    </button>
                    <script>
                        function removeUserFromDB() {
                            $.ajax({
                                url: 'cnt?action=removeStudent',
                                type: 'post',
                                data: "id=" + id,
                                success: function () {
                                    studentsTable();
                                }
                            })
                        }
                    </script>
                    <button type="button" style="background-color: #aaaaaa;color: white" class="btn btn-default"
                            data-dismiss="modal">İmtina et
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>