package com.ecare.web.serviceImpl;

import com.ecare.web.pojo.Post;
import com.ecare.web.service.PostService;
import com.ecare.web.mapper.PostMapper;
import com.ecare.web.mapper.ReplyMapper;
import com.ecare.web.pojo.Reply;
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
    public List<Post> findPostByClassId(Integer classid) {
        List<Post> posts=postMapper.selectByClassId(classid);
        return posts;
    }

    public List<Reply> findReplyByPostId(Integer postid) {
        List<Reply> replies=replyMapper.selectByPostId(postid);
        return replies;
    }
}
