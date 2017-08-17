package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Dateils;
import com.mcylm.clay.service.consoleservice.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/15/015
 * @Modified By:None one
 */
@Mapper
public interface OrderMapper {

    @Select("select * from pre_common_orders o,pre_common_orders_paymentPurposes p,pre_common_orders_state s where o.paymentPurposes=p.payId  and o.state=s.stateId")
    List<Orders> getOrderList();

    @Select("select * from pre_common_orders_details where ordersId=#{ordersUuid}")
    Dateils ordersSelect(String ordersUuid);
}
