/**
 * Created by Mikesam on 2017/7/18.
 */
function weidu() {
    $("#allmessage").css("display","none");
    $("#unreadmessage").css("display","block");
    $("#readedmessage").css("display","none");
}

function yidu() {
    $("#allmessage").css("display","none");
    $("#unreadmessage").css("display","none");
    $("#readedmessage").css("display","block");
}

function quanbu() {
    $("#allmessage").css("display","block");
    $("#unreadmessage").css("display","none");
    $("#readedmessage").css("display","none");
}

function getMessage(id) {
    $.ajax({
        type: "POST",
        dataType: "text",
        url: 'mns/getMessage',
        data:{id:id},
        success: function (dataa) {
                dataa=eval(dataa);
                setread(id);
                $("#messagetitle").text(dataa[0].title);
                $("#mesg").text(dataa[0].message);
                $("#senderby").text(dataa[0].sender);
                $("#createTime").text(dataa[0].createtime.month+1+"月"+dataa[0].createtime.date+"日"+dataa[0].createtime.hours+"时");
        }
    });
}

function setAllread() {
    $.ajax({
        type: "POST",
        dataType: "text",
        url: 'mns/setAllReadMessage',
        data:{id:1},
        success: function (data) {
            window.location.reload();
        }
    });
}

function setread(id) {
    $.ajax({
        type: "POST",
        dataType: "text",
        url: 'mns/setReadMessage',
        data:{id:id},
        success: function (data) {

        }
    });
}

