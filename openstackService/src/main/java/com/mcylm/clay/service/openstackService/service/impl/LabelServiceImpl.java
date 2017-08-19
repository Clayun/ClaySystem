package com.mcylm.clay.service.openstackService.service.impl;

import com.mcylm.clay.service.openstackService.dao.LabelDao;
import com.mcylm.clay.service.openstackService.model.label.Label;
import com.mcylm.clay.service.openstackService.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/16/016
 * @Modified By:None one
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;


    @Override
    public Label getLabel() {
        Label label=labelDao.getLabel();
        return label;
    }

}
