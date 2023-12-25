$(document).ready(function(){
   showList();
});

function showList() {
    $("#board-list").empty();

    var responseData = [];

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

    var html = ``;
    for(var index in responseData) {
        var date = responseData[index].createDate.replace('T', ' ');
        var id = responseData[index].id;
        html += `<tr style="height: 50px; vertical-align: middle;">`;
        html += `<td style="cursor:pointer;" onclick="openModal(${id})">${responseData[index].title}</td>`;
        html += `<td style="cursor:default;">${responseData[index].name}</td>`;
        html += `<td style="cursor:default;">${date}</td>`;
        html += `</tr>`;
    }

    $("#board-list").append(html);
}

function openModal(id) {
    $("#modal-title").html(id);
    document.getElementById("modal").style.display = "block";
    document.body.style.overflow = "hidden";
}

function closeModal() {
    document.getElementById("modal").style.display = "none";
    document.body.style.overflow = "auto";
}