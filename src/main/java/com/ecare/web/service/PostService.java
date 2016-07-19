package com.ecare.web.service;

import com.ecare.web.pojo.*;
import com.ecare.web.pojo.Class;
import com.ecare.web.vo.PageVo;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;

import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
public interface PostService {
    List<Class> findAllClass(PageVo page);
    List<PostFormVo> findPostByClassId(int classId, PageVo page);
    PostVo findPostByPostId(int postId);
    List<Reply> findReplyByPostId(int postId, PageVo page);
    int addPost(Post post);
    int addReply(Reply reply);
    int addLike(Likes likes);
    int addFavorite(Favorite favorite);
    List<PostFormVo> findFavoriteByUserId(int userId,PageVo page);
}
