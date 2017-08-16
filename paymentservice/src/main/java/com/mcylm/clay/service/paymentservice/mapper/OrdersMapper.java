package com.mcylm.clay.service.paymentservice.mapper;

import com.mcylm.clay.service.paymentservice.model.Account;
import com.mcylm.clay.service.paymentservice.model.ActivityDetails;
import com.mcylm.clay.service.paymentservice.model.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Mapper
public interface OrdersMapper {


    //添加用户信息
    @Insert("insert into pre_common_orders(ordersUuid,uuid,amount,paymentPurposes,remarks,paymentTime,theActualAmount,state,month)" +
            " values(#{ordersUuid},#{uuid},#{amount},#{paymentPurposes},#{remarks},now(),#{theActualAmount},5,#{month}) ")
    Integer paymentInterfaceAdd(Orders orders);

    //添加详细信息
    @Insert("insert into pre_common_orders_details(ordersId,content,length,activityId,createTime)" +
            " values(#{ordersId},#{content},#{length},#{activityId},now()) ")
    Integer paymentInterfaceOrdersDetails(@Param("ordersId") Integer ordersId, @Param("content") String content, @Param("length") Integer length, @Param("activityId") Integer activityId);

    //查询余额
    @Select("SELECT id,uuid,money,score,consume from  pre_common_account WHERE uuid=#{uuid}")
    Account getMoneyByAccountUuid(@Param("uuid") String uuid);

    //支付
    @Update("update pre_common_account set money=money-#{theActualAmount},score=score+#{score}," +
            "consume=consume+#{theActualAmount} where uuid=#{uuid}")
    int paymentInterface(@Param("theActualAmount") Integer theActualAmount, @Param("score") Integer score, @Param("uuid") String uuid);

    //修改状态
    @Update("UPDATE pre_common_orders SET state=#{state} WHERE uuid=#{uuid} and ordersUuid=#{ordersUuid}")
    Integer paymentInterfaceOrders(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("state") int state);

    //回显
    @Select("SELECT * FROM pre_common_orders WHERE uuid = #{uuid} and ordersUuid =#{ordersUuid}")
    Orders getOrdersByUuid(@Param("uuid") String uuid, @Param("ordersUuid") String ordersUuid);

    //查询活动
    @Select("select d.id,d.title,d.abstractInfo,d.content,d.num,d.startTime,d.overTime,d.managerName,s.state,t.type from pre_activities_details d,pre_activities_details_state s,pre_activities_details_type t" +
            " where d.state=s.id and d.type=t.id and d.selected=1 and d.state=2 ")
    List<ActivityDetails> getDetails();

    //查询活动
    @Select("select d.id,d.title,d.abstractInfo,d.content,d.num,d.startTime,d.overTime,d.managerName,s.state,t.type from pre_activities_details d,pre_activities_details_state s,pre_activities_details_type t where d.state=s.id and d.type=t.id and d.selected=2 and d.state=2 ")
    List<ActivityDetails> getDetailsSelected();

    //计算优惠后的价格
    @Select("select * from pre_activities_details where id=#{id}")
    ActivityDetails getDetailsById(@Param("id") Integer id);

    /*@Select("select * from pre_activities_details where id=#{selectedId}")
    ActivityDetails getDetailsBySelectId(Integer selectedId);*/
}
