package com.mcylm.clay.service.openstackService.mapper;

import com.mcylm.clay.service.openstackService.model.ecsModel.*;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/9.
 */
@Mapper
public interface EcsMapper {

    @Select("select * from pre_produce_ecs_cpu")
    List<EcsCpu> getEcsCpuList();

    @Select("select * from pre_produce_ecs_memory")
    List<EcsMemory> getEcsMemoryList();

    @Select("select * from pre_produce_ecs_expand_disk")
    List<EcsExpandDisk> getEcsExpandDiskList();

    @Select("select * from pre_produce_ecs_image_name where typeId = #{typeId}")
    List<EcsImageName> getEcsImageNameList(int typeId);

    @Select("select * from pre_produce_ecs_image_type")
    List<EcsImageType> getEcsImageTypeList();

    @Select("select * from pre_produce_ecs_ip")
    List<EcsIp> getEcsIpList();

    @Select("select * from pre_produce_ecs_os_disk")
    List<EcsOsDisk> getEcsOsDiskList();

    @Select("select * from pre_produce_ecs_tape")
    List<EcsTape> getEcsTapeList();

    @Select("select price from pre_produce_ecs_cpu where coreNum = #{coreNum}")
    double getCorePriceByValue(int size);

    @Select("select price from pre_produce_ecs_expand_disk where expanddiskSize = #{size}")
    double getExpandDiskPriceByValue(int size);

    @Select("select price from pre_produce_ecs_ip where ipNum = #{size}")
    double getIpPriceByValue(int size);

    @Select("select price from pre_produce_ecs_memory where memNum = #{size}")
    double getMemoryPriceByValue(int size);

    @Select("select price from pre_produce_ecs_os_disk where osdiskSize = #{size}")
    double getOsDiskPriceByValue(int size);

    @Select("select price from pre_produce_ecs_tape where tapeSize = #{size}")
    double getTapePriceByValue(int size);

    @Select("select * from pre_common_ucenter_server where ser_uuid = #{uuid}")
    EcsServer getEcsServerByUUID(String uuid);

    @Update("update pre_common_ucenter_server set state = #{state} where ser_uuid = #{servuuid}")
    void updateEcsServerStateBySerUuid(@Param("servuuid") String servuuid, @Param("state") int state);
}
