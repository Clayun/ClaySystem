package com.mcylm.clay.service.consoleservice.service;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
public interface ActivitiesService {
    List<Activities> activitieslist(@Param("dropdownbox") String dropdownbox, @Param("content") String content, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, Map<String, Object> map);

    void activitiesAdd(ActivitiesStr activities);

    Activities toUpdateActivities(Integer id);

    void activitiesUpdate(ActivitiesStr activities);

    int getCount(String dropdownbox, String content);
}
