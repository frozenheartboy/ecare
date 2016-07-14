package com.ecare.web.mapper;

import com.ecare.web.pojo.Post;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer postid);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postid);

    List<Post> selectByClassId(Integer classid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}