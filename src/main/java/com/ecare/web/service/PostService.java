package com.ecare.web.service;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.vo.PageVo;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;

import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
public interface PostService {
    List<PostFormVo> findPostByClassId(int classId, PageVo page);
    PostVo findPostbyPostId(int postId);
    List<Reply> findReplyByPostId(int postId, PageVo page);
    int addPost(Post post);
    int addReply(Reply reply);
}
