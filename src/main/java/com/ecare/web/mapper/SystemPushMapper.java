package com.ecare.web.mapper;

import com.ecare.web.pojo.SystemPush;

public interface SystemPushMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemPush record);

    int insertSelective(SystemPush record);

    SystemPush selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemPush record);

    int updateByPrimaryKey(SystemPush record);
}