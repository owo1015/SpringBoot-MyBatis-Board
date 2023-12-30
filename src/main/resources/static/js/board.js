$(document).ready(function(){
   showList();

   $("#modify").click(function () {
       location.href = "/postModify/" + $("#modal-id").val();
   });
});

function showList() {
    let responseData = [];

    $.ajax({
        type: "GET",
        contentType: "application/json; UTF-8;",
        url: "/api/board/list",
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
            responseData = data;
        }
    });

    let html = ``;
    for(let index in responseData) {
        let date = responseData[index].createDate.replace('T', ' ');
        let id = responseData[index].id;
        html += `<tr style="height: 50px; vertical-align: middle;">`;
        html += `<td style="cursor:pointer;" onclick="showDetail(${id})">${responseData[index].title}</td>`;
        html += `<td style="cursor:default;">${responseData[index].name}</td>`;
        html += `<td style="cursor:default;">${date}</td>`;
        html += `</tr>`;
    }

    $("#board-list").append(html);
}

function showDetail(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json; UTF-8;",
        url: "/api/board/list/" + id,
        data: {},
        dataType: 'json',
        success: function (data) {
            $("#modal-id").val(data.id);
            $("#modal-user").val(data.userId);
            $("#modal-title").html(data.title);
            $("#modal-body").html(data.content);
            openModal();
        }
    });
}

function insertBoard() {
    var data = {
        title: $("#title").val(),
        content: $("#content").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json; UTF-8;",
        url: "/api/board/insert",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function () {
            alert("게시글이 등록됐습니다.");
            location.href = "/";
        }
    });
}

function updateBoard() {
    var data = {
        id: $("#id").val(),
        title: $("#title").val(),
        content: $("#content").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json; UTF-8;",
        url: "/api/board/update",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function () {
            alert("게시글을 수정했습니다.");
            location.href = "/";
        }
    });
}

function deleteBoard() {
    var data = {
        id: $("#modal-id").val(),
    }

    $.ajax({
        type: "POST",
        contentType: "application/json; UTF-8;",
        url: "/api/board/delete",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function () {
            closeModal();
            alert("게시글을 삭제했습니다.");
            location.reload(true);
        }
    });
}

function openModal() {
    document.getElementById("modal").style.display = "block";
    document.body.style.overflow = "hidden";
    if($("#session-user").val() != $("#modal-user").val()) {
        document.getElementById("modify").style.visibility = "hidden";
        document.getElementById("delete").style.visibility = "hidden";
    } else {
        document.getElementById("modify").style.visibility = "visible";
        document.getElementById("delete").style.visibility = "visible";
    }
}

function closeModal() {
    document.getElementById("modal").style.display = "none";
    document.body.style.overflow = "auto";
}