package com.mcylm.clay.service.openstackService.service.impl;


import com.mcylm.clay.service.openstackService.dao.MessageInterfaceDao;
import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;
import com.mcylm.clay.service.openstackService.service.MessageInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
@Service
public class MessageInterfaceServiceImpl implements MessageInterfaceService {
    @Autowired
    private MessageInterfaceDao messageInterfaceDao;


    //全信息查询
    @Override
    public List<MessagesInfo> getMessagesByUuid(String uuid) {
        return messageInterfaceDao.getMessagesByUuid(uuid);
    }

    //查询未读消息条数
    @Override
    public Integer getCountByUuid(String uuid) {
        return messageInterfaceDao.getCountByUuid(uuid).size();
    }

    //查询已读的信息
    @Override
    public List<MessagesInfo> readMessage(String uuid) {
        return messageInterfaceDao.readMessage(uuid);
    }

    //查询未读的信息
    @Override
    public List<MessagesInfo> noReadMessage(String uuid) {
        return messageInterfaceDao.noReadMessage(uuid);
    }
}
