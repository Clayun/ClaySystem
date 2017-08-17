package com.mcylm.clay.service.openstackService.dao.impl;

import com.mcylm.clay.service.openstackService.dao.LabelDao;
import com.mcylm.clay.service.openstackService.mapper.LabelMapper;
import com.mcylm.clay.service.openstackService.model.label.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/16/016
 * @Modified By:None one
 */
@Repository
public class LabelDaoImpl implements LabelDao {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public Label getLabel() {
        Label label=labelMapper.getLabel();
        return label;
    }

}