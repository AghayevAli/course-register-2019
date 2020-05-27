$(function () {
    $('#myTable').hide();
    $('#moderatorsTable').hide();
    $('#modalDelete').load("pages/modal/deleteModal.jsp");
    $('#modalModerators').load("pages/modal/moderatorsDeleteModal.jsp");
    $('#modalEdit').load("pages/modal/editModal.jsp");
    let header = $('#header');
    let intro = $('#intro');
    let introH = intro.innerHeight();

    let scrollPose = $(window).scrollTop();
    $(window).on("load scroll resize", function () {
        scrollPose = $(this).scrollTop();
        introH = intro.innerHeight();
        if (scrollPose > introH) {
            header.addClass("fixed");
            $('.mynav').css({'marginBottom': '45px'})
            $('#logIn').css({'margin': '-55px'});
        } else {
            header.removeClass("fixed");
            $('#logIn').css({'margin': '25px 0'});
            $('.mynav').css({'marginBottom': '0'})
        }
    });
    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 550,
        width: 350,
        modal: true,
        buttons: [
            {
                text: "İmtina et",
                "class": 'btn btn-danger',
                click: function () {
                    $('#introSentences').show();
                    $('#logIn').show();
                    dialog.dialog("close");
                }
            },
            {
                text: "Təsdiqlə",
                "class": 'btn btn-primary',
                click: addUser
            }
        ],
        close: function () {
            $('#introSentences').show();
            $('#logIn').show();
            dialog.dialog("close");
        }
    });


    editDialog = $("#edit-form").dialog({
        autoOpen: false,
        height: 600,
        width: 350,
        modal: true,
        buttons: [
            {
                text: "İmtina et",
                "class": 'btn btn-danger',
                click: function () {
                    editDialog.dialog("close");
                }
            },
            {
                text: "Təsdiqlə",
                "class": 'btn btn-primary',
                click: openEditModal
            }
        ],
        close: function () {
            editDialog.dialog("close");
        }
    });
});