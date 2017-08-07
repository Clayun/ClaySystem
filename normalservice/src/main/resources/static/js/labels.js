$(document).ready(function () {
	$.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost/application/static/labels?id=index_head_title",
        success: function (data) {
			data=eval(data);
			$("#"+data.key).html(data.label);
        }
    });
})