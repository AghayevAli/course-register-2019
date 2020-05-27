$(function () {
    $('.studentReqBtn').click(function () {
        $('#introSentences').hide();
        $('#logIn').hide();
        $('#dialog-form').load('pages/addStudentRequest.jsp', function () {
            $("#dialog-form").dialog("open");
        })
    });
    $('#tableButton').click(function () {
        studentsTable();
        $('#myTable').toggle();
    })
    $('#moderatorsTableButton').click(function () {
        moderatorsTable();
        $('#moderatorsTable').toggle();
    })
});

function addUser() {
    $('#loading').html('<div></div><div></div><div></div><div></div>');
    var name = $('#name').val();
    var surname = $('#surname').val();
    var email = $('#email').val();
    var phoneNumber = $('#phoneNumber').val();
    var gender = $("input[name='radioBtn']:checked").val();
    var lessonType = $("#lessonTypeCombo").val();
    $.ajax({
        url: 'cnt?action=addStudent',
        type: 'post',
        data: 'name=' + name + '&surname=' + surname + '&email=' + email + '&phoneNumber=' + phoneNumber + '&gender=' + gender + '&lessonType=' + lessonType,
        success: function () {
            $('#introSentences').show();
            $("#dialog-form").dialog("close");
            document.body.scrollTop = 0;
            // $('#completeMessage').show();
            $('#completeMessage').html('<i class="fas fa-envelope-open-text"></i>' + ' Müraciətinizi tamamlamaq üçün, email ünvanınıza gələn linkə daxil olun');
            setTimeout(function () {
                $('#completeMessage').hide();
            }, 8000);
        },
        error: function () {
            alert("error!")
        }
    })
}

function loadCombo(dicKey, id) {
    $.ajax({
        url: 'cnt?action=comboDatas',
        type: 'get',
        contentType: 'html',
        data: 'dicKey=' + dicKey,
        success: function (datas) {
            if (dicKey === 'lessonType') {
                $('#lessonTypeCombo').html(datas);
                $('#editLessonTypeCombo').html(datas).prop('selectedIndex', id);
            }
            if (dicKey === 'position') {
                $('#positionCombo').html(datas).prop('selectedIndex', 3);
            }
        }
    })
}

function studentsTable() {
    $.ajax({
        url: 'cnt?action=studentList',
        type: 'get',
        contentType: 'html',
        success: function (data) {
            $('#tableBody').html(data);
        }
    })
}

function moderatorsTable() {
    $.ajax({
        url: 'cnt?action=moderatorsList',
        type: 'get',
        contentType: 'html',
        success: function (data) {
            $('#moderatorsTableBody').html(data);
        }
    })
}

function editStudent(id) {
    $.ajax({
        url: 'cnt?action=editStudent',
        type: 'get',
        data: "id=" + id,
        contentType: 'html',
        success: function (data) {
            $('#edit-form').html(data).dialog('open');
        }
    })
}

function updateStudent() {
    var id = $('#editStudentID').val();
    var editedName = $('#editName').val();
    var editedSurname = $('#editSurname').val();
    var editedEmail = $('#editEmail').val();
    var editedPhoneNumber = $('#editPhoneNumber').val();
    var editedRadioBtn = $('input[name="radioBtn"]:checked').val();
    var editedComboBox = $('#editLessonTypeCombo').val();
    var position = $('#positionCombo').val();
    $.ajax({
        url: 'cnt?action=updateStudent',
        type: 'get',
        data: "id=" + id + "&name=" + editedName + "&surname=" + editedSurname + "&email=" + editedEmail + "&phoneNumber=" + editedPhoneNumber + "&gender=" + editedRadioBtn + "&lessonType=" + editedComboBox + "&position=" + position,
        success: function () {
            $('#edit-form').dialog('close');
            studentsTable();
            moderatorsTable();
        }
    })
}

function openEditModal() {
    $('#editModal').modal('show');
}




