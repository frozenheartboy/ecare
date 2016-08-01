package com.ecare.web.mapper;

import com.ecare.web.pojo.Reply;
import com.ecare.web.vo.ReplyFormVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);

    List<ReplyFormVo> selectByPostId(@Param("postId") Integer postId, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);

    int updateReplyLikes(Integer replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}