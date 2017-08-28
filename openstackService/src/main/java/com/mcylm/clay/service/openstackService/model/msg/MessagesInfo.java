package com.mcylm.clay.service.openstackService.model.msg;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件消息类
 * Created by lenovo-pc on 2017/8/21.
 */
public class MessagesInfo implements Serializable {
    private Integer id;            //自增ID
    private String recivierUuid;//接受者Id
    private String senderUuid;  //发送者Id
    private String message;      //信息内容
    private Date createTime; //信息创建时间
    private String readed;      //是否已读

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecivierUuid() {
        return recivierUuid;
    }

    public void setRecivierUuid(String recivierUuid) {
        this.recivierUuid = recivierUuid;
    }

    public String getSenderUuid() {
        return senderUuid;
    }

    public void setSenderUuid(String senderUuid) {
        this.senderUuid = senderUuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReaded() {
        return readed;
    }

    public void setReaded(String readed) {
        this.readed = readed;
    }

    @Override
    public String toString() {
        return "MessagesInfo{" +
                "id=" + id +
                ", recivierUuid='" + recivierUuid + '\'' +
                ", senderUuid='" + senderUuid + '\'' +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                ", readed=" + readed +
                '}';
    }
}
