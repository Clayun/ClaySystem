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

    @Insert("insert into pre_common_account(uuid,money,score,consume) values(#{uuid},#{money},#{score},#{consume}) ")
    void ucenteradd(Account account);

    @Update("update pre_common_account set money=#{money},score=#{score},consume=#{consume} where id = #{id}")
    void accountupdate(Account account);

    @Delete("delete from pre_common_account where id=#{id}")
    void accountdel(Integer id);
}