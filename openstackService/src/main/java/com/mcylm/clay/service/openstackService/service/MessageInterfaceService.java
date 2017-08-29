package com.mcylm.clay.service.openstackService.service;


import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
public interface MessageInterfaceService {
    //全部信息查询
    List<MessagesInfo> getMessagesByUuid(String uuid);

    //查询未读消息数
    Integer getCountByUuid(String uuid);

    //查询已读的信息
    List<MessagesInfo> readMessage(String uuid);

    //查询未读的信息
    List<MessagesInfo> noReadMessage(String uuid);
}
