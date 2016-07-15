package com.ecare.web.mapper;

import com.ecare.web.pojo.Likes;

public interface LikesMapper {
    int deleteByPrimaryKey(Integer likesId);

    int insert(Likes record);

    int insertSelective(Likes record);

    Likes selectByPrimaryKey(Integer likesId);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}