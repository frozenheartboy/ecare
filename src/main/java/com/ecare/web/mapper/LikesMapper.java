package com.ecare.web.mapper;

import com.ecare.web.pojo.Likes;
import org.apache.ibatis.annotations.Param;

public interface LikesMapper {
    int deleteByPrimaryKey(Integer likesId);

    int insert(Likes record);

    int insertSelective(Likes record);

    Likes selectByPrimaryKey(Integer likesId);

    Integer selectByContent(Likes record);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}