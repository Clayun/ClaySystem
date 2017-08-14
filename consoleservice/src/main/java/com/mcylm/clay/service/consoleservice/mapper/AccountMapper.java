package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Account;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
@Mapper
public interface AccountMapper {

    @Select("select * from pre_common_account")
    List<Account> getaccountlist(Map<String,Object> map);

}