/**
 * Created by Mikesam on 2017/7/11.
 */
function logout() {
    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/ucenter/loginout',
        data:{logout:1},
        success: function (data) {
            window.location.href = "/index/portal";
        }
    });
}