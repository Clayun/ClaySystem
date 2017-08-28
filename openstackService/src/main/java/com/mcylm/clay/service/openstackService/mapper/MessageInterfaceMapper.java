package com.mcylm.clay.service.openstackService.mapper;

import com.mcylm.clay.service.openstackService.model.msg.MessagesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/8/21.
 */
@Mapper
public interface MessageInterfaceMapper {

    //查询全部信息
    @Select("SELECT * from pre_message_info WHERE readed<>'删除' AND recivierUuid = #{uuid}")
    List<MessagesInfo> getMessageByUuid(@Param("uuid") String uuid);

    //查询未读的信息数
    // SELECT COUNT(*) from pre_message_info WHERE readed='未读' AND recivierUuid ='30e6d8723f3a4e7ba051f4b09c2bcd92'
    @Select("SELECT * from pre_message_info WHERE readed='未读' AND recivierUuid = #{uuid}")
    List<MessagesInfo> getCountByUuid(@Param("uuid") String uuid);

    //查询已读的信息
    @Select("SELECT * from pre_message_info WHERE readed='已读' AND recivierUuid = #{uuid}")
    List<MessagesInfo> readMessage(@Param("uuid") String uuid);

    //查询未读的信息
    @Select("SELECT * from pre_message_info WHERE readed='未读' AND recivierUuid = #{uuid}")
    List<MessagesInfo> noReadMessage(@Param("uuid") String uuid);
}
