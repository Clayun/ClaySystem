var token = "";
var loginType = "";
var formToken = "";
function takeparam(url) {
    redirectUrl = getQueryString("redirectUrl");//获取token
    token = getQueryString("token");//获取token
    loginType = getQueryString("loginType");//获取logintype
    formToken = getQueryString("formToken");//获取logintype

    //判断是否有redirectUrl
    if (redirectUrl != null && redirectUrl != '') {
        url = checkParam(url) + "redirectUrl=" + redirectUrl;
    }
    //判断是否有token
    if (token != null && token != '') {
        url = checkParam(url) + "token=" + token;
    }
    //判断是否有loginType
    if (loginType != null && loginType != '') {
        url = checkParam(url) + "loginType=" + loginType;
    }
  //获取formToken
    if (formToken != null && formToken != '') {
        url = checkParam(url) + "formToken=" + formToken;
    }
    //跳转路径
    window.location.href="http://localhost"+url;
}

//获取路径上指定的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
function checkParam(url) {
    //防止路径符号错误
    if (url.indexOf("?") != -1) {
        url += "&";
    } else {
        url += "?";
    }
    return url;
}

