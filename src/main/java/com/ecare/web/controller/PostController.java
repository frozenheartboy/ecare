package com.ecare.web.controller;

import com.ecare.web.service.PostService;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
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
    public  Map<String,Object>  findPostByClassId(@RequestParam("classid") Integer classid){
        List<Post> posts=postService.findPostByClassId(classid);
        return ResultUtil.getResult(200,"查询成功",posts);
    }
    @RequestMapping(value = "/findReply")
    @ResponseBody
    public  Map<String,Object>  findReplyByPostId(@RequestParam("postid") Integer postid){
        List<Reply> replies=postService.findReplyByPostId(postid);
        return ResultUtil.getResult(200,"查询成功",replies);
    }
}
