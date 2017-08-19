package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Orders;
import com.mcylm.clay.service.consoleservice.model.Token;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/17/017
 * @Modified By:None one
 */
@Mapper
public interface TokenMapper {

    @Select("select * from pre_common_uauth_token")
    List<Token> getOrderList();

}