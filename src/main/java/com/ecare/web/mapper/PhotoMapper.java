package com.ecare.web.mapper;

import com.ecare.web.pojo.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photeid);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photeid);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}