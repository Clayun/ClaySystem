package com.mcylm.clay.service.openstackService.dao.impl;


import com.mcylm.clay.service.openstackService.dao.MessageInterfaceDao;
import com.mcylm.clay.service.openstackService.mapper.MessageInterfaceMapper;
import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
@Repository
public class MessageInterfaceDaoImpl implements MessageInterfaceDao {
    @Autowired
    private MessageInterfaceMapper messageInterfaceMapper;

    //查询全部信息
    @Override
    public List<MessagesInfo> getMessagesByUuid(String uuid) {
        return messageInterfaceMapper.getMessageByUuid(uuid);
    }

    //查询未读信息条数
    @Override
    public List<MessagesInfo> getCountByUuid(String uuid) {
        return messageInterfaceMapper.getCountByUuid(uuid);
    }

    //查询未读的信息
    @Override
    public List<MessagesInfo> noReadMessage(String uuid) {
        return messageInterfaceMapper.noReadMessage(uuid);
    }

    //查询已读的信息
    @Override
    public List<MessagesInfo> readMessage(String uuid) {
        return messageInterfaceMapper.readMessage(uuid);
    }
}
