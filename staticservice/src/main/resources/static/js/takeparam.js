var token = "";
var loginType = "";
function takeparam(url) {
    token = getQueryString("token");//获取token
    loginType = getQueryString("loginType");//获取logintype
    //判断是否有token
    if (token != null && token != '') {
        url += "?token=" + token;
    }
    //防止路径符号错误
    if (url.indexOf("?") != -1) {
        url += "?";
    } else {
        url += "&";
    }
    //获取loginType
    if (loginType != null&&loginType!='') {
        url += "loginType="+loginType;
    }
    //跳转路径
    window.location.href="http://"+url;
}

//获取路径上指定的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}


