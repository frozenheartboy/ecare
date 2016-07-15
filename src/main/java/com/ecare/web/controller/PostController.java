package com.ecare.web.controller;

import com.ecare.web.pojo.Post;
import com.ecare.web.pojo.Reply;
import com.ecare.web.service.PostService;
import com.ecare.web.util.PageUtil;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
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
    public  Map<String,Object>  findPostByClassId(@RequestParam("classId") Integer classId,@RequestParam("page") Integer pageNumber){
        List<Post> posts=postService.findPostByClassId(classId,PageUtil.getPage(pageNumber,5));
        if(posts.size()!=0)
            return ResultUtil.getResult(Constant.SUCCESS,"查询成功",posts);
        else
            return ResultUtil.getResult(Constant.FAILURE,"查询为空",posts);
    }
    @RequestMapping(value = "/findReply")
    @ResponseBody
    public  Map<String,Object>  findReplyByPostId(@RequestParam("postId") Integer postId,@RequestParam("page") Integer pageNumber){
        List<Reply> replies=postService.findReplyByPostId(postId,PageUtil.getPage(pageNumber,5));
        return ResultUtil.getResult(Constant.SUCCESS,"查询成功",replies);
    }

//    @RequestMapping(value ="/addPost",method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String ,Object> addPost(@RequestBody() Post post){
//        return ResultUtil.getResult(Constant.SUCCESS,"查询成功",);
//    }
}
