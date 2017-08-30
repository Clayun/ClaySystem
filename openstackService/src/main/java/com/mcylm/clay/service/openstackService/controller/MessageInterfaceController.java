package com.mcylm.clay.service.openstackService.controller;


import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;
import com.mcylm.clay.service.openstackService.model.ucenter.UauthToken;
import com.mcylm.clay.service.openstackService.service.MessageInterfaceService;
import com.mcylm.clay.service.openstackService.utils.Base64Utils;
import com.mcylm.clay.service.openstackService.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
@Controller
@RequestMapping("/message")
public class MessageInterfaceController {
    @Autowired
    private MessageInterfaceService messageInterfaceService;


    /***
     * 全部信息查询
     * @param //uuid
     * @return
     */
    @RequestMapping("/messageInterface")
    public String messageInterface(String token,Model model) {
        List<MessagesInfo> messagesInfoList = messageInterfaceService.getMessagesByUuid(getUUidByToken(token));
        model.addAttribute("messagesInfoList", messagesInfoList);
        return "message";
    }

    /**
     * 已读消息
     *
     * @param model
     * @return
     */
    @RequestMapping("/readMessage")
    public String readMessage(String token,Model model) {
        List<MessagesInfo> messagesInfoList = messageInterfaceService.readMessage(getUUidByToken(token));
        model.addAttribute("messagesInfoList", messagesInfoList);
        return "message";
    }

    /**
     * 未读消息
     *
     * @param model
     * @return
     */
    @RequestMapping("/noReadMessage")
    public String noReadMessage(String token ,Model model) {
        List<MessagesInfo> messagesInfoList = messageInterfaceService.noReadMessage(getUUidByToken(token));
        model.addAttribute("messagesInfoList", messagesInfoList);
        return "message";
    }

    /**
     * 查询未读的信息数
     *
     * @return
     */
    @RequestMapping("/getCountByUuid")
    @ResponseBody
    public Integer getCountByUuid(String token) {
        return messageInterfaceService.getCountByUuid(getUUidByToken(token));
    }

    private String getUUidByToken(String uuid) {

        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }

}
