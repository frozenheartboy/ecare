package com.ecare.web.controller;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.service.PostService;
import com.ecare.web.util.PageUtil;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import com.ecare.web.vo.PageVo;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;
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

    @RequestMapping(value = "/findPost")
    @ResponseBody
    public Map<String, Object> findPostByClassId(@RequestParam(value = "classId") int classId, @RequestParam(value = "page") int pageNumber) {

        if (pageNumber > -1) {
            List<PostFormVo> postFormVos = postService.findPostByClassId(classId, PageUtil.getPage(pageNumber, Constant.POST_PAGE_NUMBER));
            if (postFormVos.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", postFormVos);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }
    @RequestMapping(value = "/getPost")
    @ResponseBody
    public Map<String, Object> findPostByPostId(@RequestParam(value = "PostId") int postId) {
        PostVo postVo=postService.findPostbyPostId(postId);
        if(postVo!=null)
            return ResultUtil.getResult(Constant.SUCCESS,"查找成功",postVo);
        return ResultUtil.getResult(Constant.FAILURE,"查找失败",null);

    }
    @RequestMapping(value = "/findReplies")
    @ResponseBody
    public Map<String, Object> findReplyByPostId(@RequestParam("postId") int postId, @RequestParam("page") int pageNumber) {
        if (pageNumber > -1) {
            List<Reply> replies = postService.findReplyByPostId(postId, PageUtil.getPage(pageNumber, Constant.REPLY_PAGE_NUMBER));
            if (replies.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", replies);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPost(@ModelAttribute Post post ,@RequestParam("user_id") int userId) {
        post.setPostUserId(userId);
        int result = postService.addPost(post);
        if (result != 0) {
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", post.getPostId());
        }
        else
            return ResultUtil.getResult(Constant.FAILURE, "添加失败", result);
    }

    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addReply(@ModelAttribute Reply reply ,@RequestParam("user_id") int userId) {
        reply.setReplyUserId(userId);
        int result = postService.addReply(reply);
        if (result != 0) {
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", reply.getReplyId());
        }
        else
            return ResultUtil.getResult(Constant.FAILURE, "添加失败", result);
    }

}
