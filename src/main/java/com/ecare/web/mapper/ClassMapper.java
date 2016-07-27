package com.ecare.web.mapper;

import com.ecare.web.pojo.Class;
import com.ecare.web.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classId);

    Integer selectByClassName(String className);

    List<Integer> selectAllClassId();

    List<Class> selectLikeClassKey(@Param("classKey") String classKey, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);

    List<Class> selectAll(@Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);

    int updateNameDesc(Class record);
    int updateClassViews(Integer classId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}