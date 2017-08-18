var token = "";
$(function () {
        token = getQueryString("token");
    if (token!=""&&token!=null){

        $.ajax({
            url:"security/author/checkLogin",
            data:{token:token},
            dataType:"json",
            type:"POST",
            success:function (data) {
                if (data!=null){
                    $("#ulg").css("display","none");
                    $("#lg").show();
                    $("#uname").val(data.userName);
                }
            }

        })
    }
    $("#uname").click(function () {
        var url = "/ucenter/portal?token="+token;
        window.location.href=url
    })
})

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
function logout() {
    $.ajax({
        type: "POST",
        dataType: "text",
        url: 'security/author/logout',
        data:{token:token},
        success: function (data) {
            window.location.href = "http://localhost/";
        }
    });
}