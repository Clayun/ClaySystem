package com.mcylm.clay.service.openstackService.mapper;

import com.mcylm.clay.service.openstackService.model.label.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/16/016
 * @Modified By:None one
 */
@Mapper
public interface LabelMapper {

    @Select("select * from htm_common_template")
    Label getLabel();
}