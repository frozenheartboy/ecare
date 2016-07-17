package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.PostMapper;
import com.ecare.web.mapper.ReplyMapper;
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
    public List<PostFormVo> findPostByClassId(int classId, PageVo page) {
        return postMapper.selectByClassId(classId,page.getPageStart(),page.getPageSize());
    }

    public PostVo findPostbyPostId(int postId) {
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
}
