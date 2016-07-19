package com.ecare.web.mapper;

import com.ecare.web.pojo.Photo;

import java.util.List;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoId);

    List<String> selectByPostId(Integer postId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}