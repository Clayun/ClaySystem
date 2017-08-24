package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Dateils;
import com.mcylm.clay.service.consoleservice.model.Orders;
import com.mcylm.clay.service.consoleservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/15/015
 * @Modified By:None one
 */

@Controller
@RequestMapping("/orders")
public class OrderAction {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderlist")
    public String orderlist(Map<String,Object> map){
        List<Orders> list=orderService.getOrderList();
        map.put("list",list);
        return "order";
    }

    @RequestMapping("/ordersSelect")
    public String ordersSelect(String ordersUuid,Map<String,Object> map){
        Dateils dateils=orderService.ordersSelect(ordersUuid);
        map.put("dateils",dateils);
        return "xiangqin";
    }

}