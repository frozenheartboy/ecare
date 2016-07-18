package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.FavoriteMapper;
import com.ecare.web.mapper.LikesMapper;
import com.ecare.web.mapper.PostMapper;
import com.ecare.web.mapper.ReplyMapper;
import com.ecare.web.pojo.Favorite;
import com.ecare.web.pojo.Likes;
import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.service.PostService;
import com.ecare.web.vo.PageVo;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private LikesMapper likesMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;
    public List<PostFormVo> findPostByClassId(int classId, PageVo page) {
        return postMapper.selectByClassId(classId,page.getPageStart(),page.getPageSize());
    }

    public PostVo findPostByPostId(int postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    public List<Reply> findReplyByPostId(int postId, PageVo page) {
        return replyMapper.selectByPostId(postId,page.getPageStart(),page.getPageSize());
    }

    public int addPost(Post post) {
        return postMapper.insertSelective(post);
    }

    public int addReply(Reply reply) {
        return replyMapper.insertSelective(reply);
    }

    public int addLike(Likes likes) {
        Integer result=likesMapper.selectByContent(likes);
        if(result==null)
            return likesMapper.insertSelective(likes);
        else
            return 0;
    }

    public int addFavorite(Favorite favorite) {
        Integer result = favoriteMapper.selectByContent(favorite);
        if(result==null)
            return favoriteMapper.insertSelective(favorite);
        else
            return 0;
    }

}
