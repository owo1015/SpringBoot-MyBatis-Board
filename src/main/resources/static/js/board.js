$(document).ready(function(){
   showList();
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
    let board = null;

    $.ajax({
        type: "GET",
        contentType: "application/json; UTF-8;",
        url: "/api/board/" + id,
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
            board = data;
        }
    });

    $("#modal-title").html(board.title);
    $("#modal-body").html(board.content);

    openModal(board.id);
}

function openModal(id) {
    document.getElementById("modal").style.display = "block";
    document.body.style.overflow = "hidden";

    document.getElementById("update").addEventListener("click", () => {
        location.href="/postUpdate";
    });

    document.getElementById("delete").addEventListener("click", () => {
        location.href = "/api/board/" + id + "/delete";
        alert("게시글이 삭제되었습니다.");
    });
}


function closeModal() {
    document.getElementById("modal").style.display = "none";
    document.body.style.overflow = "auto";
}