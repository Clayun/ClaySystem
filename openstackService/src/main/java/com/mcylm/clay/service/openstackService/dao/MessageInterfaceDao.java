package com.mcylm.clay.service.openstackService.dao;


import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
public interface MessageInterfaceDao {
    //查询全部信息
    List<MessagesInfo> getMessagesByUuid(String uuid);

    //查询未读信息条数
    List<MessagesInfo> getCountByUuid(String uuid);

    //查询已读的信息
    List<MessagesInfo> readMessage(String uuid);

    //查询未读的信息
    List<MessagesInfo> noReadMessage(String uuid);
}
