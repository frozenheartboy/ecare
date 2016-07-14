package com.ecare.web.mapper;

import com.ecare.web.pojo.Reply;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyid);

    List<Reply> selectByPostId(Integer postid);
    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}