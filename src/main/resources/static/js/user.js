function signup() {
    var data = {
        id: $("#id").val(),
        password: $("#password").val(),
        name: $("#name").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json; UTF-8;",
        url: "/api/user/signup",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (data) {
            alert("회원가입 성공");
            location.href = "/login";
        }
    });
}