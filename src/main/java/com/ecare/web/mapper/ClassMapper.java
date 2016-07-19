package com.ecare.web.mapper;

import com.ecare.web.pojo.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classId);

    List<Class> selectAll(@Param("pageStart") Integer pageStart,@Param("pageSize") Integer pageSize);

    int updateClassViews(Integer classId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}