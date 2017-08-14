package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by macbook on 2017/8/11.
 */
@Mapper
public interface ActivitiesMapper {

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id")
    List<Activities> activitieslist();

    @Insert("insert into pre_activities_details(type,title,abstractInfo,content,num,startTime,overTime," +
            "managerName,state,selected) values(#{type},#{title},#{abstractInfo},#{content},#{num}," +
            "#{startTime},#{overTime},#{managerName},#{state},#{selected})")
    void activitiesAdd(ActivitiesStr activities);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id and a.id = #{id}")
    Activities toUpdateActivities(@Param("id") Integer id);

    @Update("update pre_activities_details set type=#{type},title=#{title},abstractInfo=#{abstractInfo}," +
            "content=#{content},num=#{num},startTime=#{startTime},overTime=#{overTime}," +
            "managerName=#{managerName},state=#{state},selected=#{selected} where id = #{id}")
    void activitiesUpdate(ActivitiesStr activities);

}
