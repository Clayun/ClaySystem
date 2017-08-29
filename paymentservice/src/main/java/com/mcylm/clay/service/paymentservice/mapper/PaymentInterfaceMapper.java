package com.mcylm.clay.service.paymentservice.mapper;

import com.mcylm.clay.service.paymentservice.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/7.
 */
@Mapper
public interface PaymentInterfaceMapper {


    //添加用户信息
    @Insert("insert into pre_common_orders(ordersUuid,paymentPurposes,paymentTime,state,remarks)" +
            " values(#{ordersUuid},#{paymentPurposes},#{paymentTime},#{state},#{remarks}) ")
    Integer paymentInterfaceAdd(Orders orders);

    //添加详细信息
    @Insert("insert into pre_common_orders_details(ordersId,content,createTime)" +
            " values(#{odersUuid},#{content},#{createTime}) ")
    Integer paymentInterfaceOrdersDetails(@Param("odersUuid") String odersUuid, @Param("content") String content, @Param("createTime") Date createTime);

    //查询余额
    @Select("SELECT id,uuid,money,score,consume from  pre_common_account WHERE uuid=#{uuid}")
    Account getMoneyByAccountUuid(@Param("uuid") String uuid);

    @Update("update pre_common_account set money=money-#{theActualAmount},score=score+#{score}," +
            "consume=consume+#{theActualAmount} where uuid=#{uuid}")
    int paymentInterface(@Param("theActualAmount") Double theActualAmount, @Param("score") Integer score, @Param("uuid") String uuid);

    //修改状态
    @Update("UPDATE pre_common_orders SET state=#{state} WHERE uuid=#{uuid} and ordersUuid=#{ordersUuid}")
    Integer paymentInterfaceOrders(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("state") int state);

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

    //添加服务器表
    @Insert("insert into pre_common_ucenter_server (uuid, ser_uuid,ser_name, cpu, memory, os_disk, expand_disk, tape, ips, image, password,days, pricePerMonth, state, createTime) values (#{uuid}, #{ser_uuid},#{ser_name}, #{cpu}, #{memory},  #{os_disk}, #{expand_disk}, #{tape}, #{ips}, #{image}, #{password},  #{days}, #{pricePerMonth}, #{state},  #{createTime})")
    Integer paymentInterfaceEcsServer(EcsServer ecsServer);

    //修改Orders
    @Update("UPDATE pre_common_orders SET uuid=#{uuid},amount=#{sum},theActualAmount=#{pricePerMonth},month=#{month} WHERE ordersUuid=#{ordersUuid}")
    Integer updateOrders(@Param("ordersUuid") String ordersUuid, @Param("uuid") String uuid, @Param("sum") double sum, @Param("pricePerMonth") Double pricePerMonth, @Param("month") Integer month);

    //补充ordersDetails
    @Update("UPDATE pre_common_orders_details SET length=#{month},activityId=#{check_val} WHERE ordersId=#{ordersUuid}")
    Integer updateOrdersDetails(@Param("ordersUuid") String ordersUuid, @Param("month") Integer month, @Param("check_val") String check_val);

    //修改服务
    @Update("UPDATE pre_common_ucenter_server SET uuid=#{uuid} WHERE ser_uuid=#{ser_uuid}")
    Integer updateEcsServer(@Param("uuid") String uuid, @Param("ser_uuid") String ser_uuid);

    //查手机号
    @Select("SELECT phone FROM pre_common_uauth WHERE uuid = #{uuid}")
    Uauth getUserPhone(@Param("uuid") String uuid);
}
