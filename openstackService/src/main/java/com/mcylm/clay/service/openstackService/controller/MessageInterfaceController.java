package com.mcylm.clay.service.openstackService.controller;


import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;
import com.mcylm.clay.service.openstackService.service.MessageInterfaceService;
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
    public String messageInterface(/*String uuid*/Model model) {
        String uuid = "30e6d8723f3a4e7ba051f4b09c2bcd92";
        List<MessagesInfo> messagesInfoList = messageInterfaceService.getMessagesByUuid(uuid);
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
    public String readMessage(/*String uuid*/Model model) {
        String uuid = "30e6d8723f3a4e7ba051f4b09c2bcd92";
        List<MessagesInfo> messagesInfoList = messageInterfaceService.readMessage(uuid);
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
    public String noReadMessage(/*String uuid*/Model model) {
        String uuid = "30e6d8723f3a4e7ba051f4b09c2bcd92";
        List<MessagesInfo> messagesInfoList = messageInterfaceService.noReadMessage(uuid);
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
    public Integer getCountByUuid() {
        String uuid = "30e6d8723f3a4e7ba051f4b09c2bcd92";
        return messageInterfaceService.getCountByUuid(uuid);
    }

}
