package com.mcylm.cley.service.userservice.mapper;

import com.mcylm.cley.service.userservice.entity.UcenterD;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface UcenterMapper{
    @Select("SELECT * FROM pre_common_ucenter_details ud LEFT JOIN pre_common_orders os ON ud.uuid=os.uuid LEFT JOIN pre_common_orders_details od ON os.id=od.ordersId")
    List<UcenterD> getUserList();

    @Update("update pre_common_ucenter_details ")
    UcenterD updateUser(UcenterD user);
}
