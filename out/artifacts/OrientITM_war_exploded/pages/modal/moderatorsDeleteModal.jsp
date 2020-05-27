<%@ page import="dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var id;

    function removeModerator(userId, roleId) {
        id = userId;
        roleIddd = roleId;
    }
</script>
<div class="container">
    <div class="modal fade" id="moderatorModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 class="modal-title">ADMIN PANEL</h2>
                </div>
                <div class="modal-body">
                    <p>Məlumatlarının tamamilə siyahıdan silmək istədiyinizə əminsiniz?</p>
                </div>
                <div class="modal-footer">
                    <button onclick="removeModeratorFromDB()" type="button" style="background-color: red;color: white"
                            class="btn btn-default" data-dismiss="modal">Bəli
                    </button>
                    <script>
                        function removeModeratorFromDB() {
                            $.ajax({
                                url: 'cnt?action=removeModerator',
                                type: 'post',
                                data: "id=" + id + "&roleId=" + roleIddd,
                                success: function () {
                                    moderatorsTable();
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