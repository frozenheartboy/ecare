package com.ecare.web.mapper;

import com.ecare.web.pojo.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photoid);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoid);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}