package com.mcylm.clay.service.paymentservice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
@Mapper
public interface RechargeInterfaceMapper {
    //充值amount=#{sum},theActualAmount=#{pricePerMonth},month=#{month}
    @Insert("insert into pre_common_orders(ordersUuid,uuid,paymentPurposes,paymentTime,state,remarks,amount,theActualAmount,month)" +
            " values(#{ordersUuid},#{uuid},2,now(),1,'-',#{amount},#{amount},'-') ")
    Integer rechargeInterface(@Param("uuid") String uuid, @Param("amount") Double amount,@Param("ordersUuid") String ordersUuid);

    //加钱
    @Update("update pre_common_account set money=money+#{amount} where uuid=#{uuid}")
    Integer addAccount(@Param("uuid") String uuid,@Param("amount") Double amount);
}
