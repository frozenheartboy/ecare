package com.ecare.web.controller;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.service.PostService;
import com.ecare.web.util.PageUtil;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2016/7/13.
 */
@Controller
@RequestMapping("/Post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Map<String, Object> findPostByClassId(@RequestParam("classId") int classId, @RequestParam("page") int pageNumber) {
        if (pageNumber > -1) {
            List<Post> posts = postService.findPostByClassId(classId, PageUtil.getPage(pageNumber, 5));
            if (posts.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", posts);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/findReply")
    @ResponseBody
    public Map<String, Object> findReplyByPostId(@RequestParam("postId") int postId, @RequestParam("page") int pageNumber) {
        if (pageNumber > -1) {
            List<Reply> replies = postService.findReplyByPostId(postId, PageUtil.getPage(pageNumber, 5));
            if (replies.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", replies);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPost(@RequestBody Post post) {
//        post.setPostTop(false);
//        post.setPostLikes(0);
//        post.setPostViews(0);
        int result = postService.addPost(post);
        if (result != 0) {
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", post.getPostId());
        }
        else
            return ResultUtil.getResult(Constant.FAILURE, "添加失败", result);
    }


}
