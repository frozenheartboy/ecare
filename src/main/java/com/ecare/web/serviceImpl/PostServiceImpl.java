package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.PostMapper;
import com.ecare.web.mapper.ReplyMapper;
import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.service.PostService;
import com.ecare.web.vo.PageVo;
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
    public List<Post> findPostByClassId(Integer classId, PageVo page) {
        List<Post> posts=postMapper.selectByClassId(classId,page.getPageStart(),page.getPageSize());
        return posts;
    }

    public List<Reply> findReplyByPostId(Integer postId, PageVo page) {
        List<Reply> replies=replyMapper.selectByPostId(postId,page.getPageStart(),page.getPageSize());
        return replies;
    }
}
