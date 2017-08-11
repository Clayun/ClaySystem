package com.mcylm.clay.service.paymentservice.mapper;

import com.mcylm.clay.service.paymentservice.model.Orders;
import com.mcylm.clay.service.paymentservice.model.OrdersState;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Mapper
public interface OrdersMapper {

    //支付
    @Update("update pre_common_account set money=money-#{theActualAmount},score=score+#{score}," +
            "consume=consume+#{theActualAmount} where uuid=#{uuid}")
    int paymentInterface(@Param("theActualAmount") Integer theActualAmount, @Param("score") Integer score,@Param("uuid") String uuid);

    @Select("select * from pre_common_orders")
    List<Orders> paymentInterfaceList();

    @Insert("insert into pre_common_orders(uuid，amount，paymentPurposes，remarks，paymentTime，theActualAmount，state)" +
            " values(#{uuid},#{amount},#{paymentPurposes},#{remarks},#{paymentTime},#{theActualAmount},#{state}) ")
    Integer paymentInterfaceAdd(Orders orders);

    @Select("select * from pre_common_orders_state s where s.stateId = #{state}")
    OrdersState getStateNameById(Integer state);

   /* @Select("select * from pre_common_orders_state s where s.stateId = #{paymentPurposes}")
    OrdersState getStateNameBypaymentPurposes(Integer paymentPurposes);*/
}
