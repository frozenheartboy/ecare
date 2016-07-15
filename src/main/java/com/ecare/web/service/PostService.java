package com.ecare.web.service;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.vo.PageVo;

import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
public interface PostService {
    List<Post> findPostByClassId(int classId, PageVo page);
    List<Reply> findReplyByPostId(int postId, PageVo page);
    int addPost(Post post);
}
