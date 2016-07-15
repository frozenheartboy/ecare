package com.ecare.web.service;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.vo.PageVo;

import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
public interface PostService {
    public List<Post>findPostByClassId(Integer classId, PageVo page);
    public List<Reply>findReplyByPostId(Integer postId, PageVo page);
}
