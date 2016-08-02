package com.ecare.web.controller;

import com.ecare.web.mapper.ClassMapper;
import com.ecare.web.pojo.*;
import com.ecare.web.pojo.Class;
import com.ecare.web.redis.RedisDao;
import com.ecare.web.service.PostService;
import com.ecare.web.util.PageUtil;
import com.ecare.web.util.ResultUtil;
import com.ecare.web.vo.Constant.Constant;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;
import com.ecare.web.vo.ReplyFormVo;
import com.ecare.web.vo.UserSimpleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by L on 2016/7/13.
 */
@Controller
@RequestMapping("/Post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/findClass")
    @ResponseBody
    public Map<String, Object> findAllClass(@RequestParam(value = "page") Integer pageNumber) {
        if (pageNumber > -1) {
            List<Class> classList = postService.findAllClass(PageUtil.getPage(pageNumber, Constant.CLASS_PAGE_NUMBER, Constant.HOME_CLASS_PAGE_NUMBER));
            if (classList.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", classList);
            else
                return ResultUtil.getResult(Constant.SUCCESS, "查询为空", classList);

        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/getClass")
    @ResponseBody
    public Map<String, Object> findClassByClassId(@RequestParam(value = "classId") Integer classId) {
        if (classId > 0) {
            postService.updateClassViews(classId);
            Class classVo = postService.findClassByClassId(classId);
            if (classVo != null) {
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", classVo);
            }
            return ResultUtil.getResult(Constant.SUCCESS, "查询为空", classVo);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/addClass")
    @ResponseBody
    public Map<String, Object> addClass(@ModelAttribute Class classVo, @RequestParam("user_id") Integer user_id) {

        if (postService.findClassByClassName(classVo.getClassName()) != null) {
            return ResultUtil.getResult(Constant.FAILURE, "话题已存在", null);
        }
        classVo.setClassCreaterId(user_id);
        int result = postService.addClass(classVo);
        if (result != 0) {
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", null);
        }
        return ResultUtil.getResult(Constant.FAILURE, "添加失败", null);
    }

    @RequestMapping(value = "/updateClass")
    @ResponseBody
    public Map<String, Object> updateClass(@ModelAttribute Class classVo) {
        Integer resultClassId = postService.findClassByClassName(classVo.getClassName());

        if (resultClassId != classVo.getClassId() && resultClassId != null) {
            return ResultUtil.getResult(Constant.FAILURE, "话题已存在", null);
        }
        if (!classVo.getClassName().equals("")) {
            int result = postService.updateClassNameDesc(classVo);
            if (result != 0) {
                return ResultUtil.getResult(Constant.SUCCESS, "修改成功", null);
            }
        }
        return ResultUtil.getResult(Constant.FAILURE, "修改失败", null);
    }

    @RequestMapping(value = "/findClassLikeKey")
    @ResponseBody
    public Map<String, Object> findClassLikeClassKey(@RequestParam("classKey") String classKey, @RequestParam(value = "page") Integer pageNumber) {
        if (pageNumber > -1) {
            List<Class> classList = postService.findClassLikeClassKey("%" + classKey + "%", PageUtil.getPage(pageNumber, Constant.CLASS_PAGE_LIKE_NUMBER, 0));
            if (classList.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", classList);
            else
                return ResultUtil.getResult(Constant.SUCCESS, "查询为空", classList);

        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/findPost")
    @ResponseBody
    public Map<String, Object> findPostByClassId(@RequestParam(value = "classId") Integer classId, @RequestParam(value = "page") Integer pageNumber) {

        if (pageNumber > -1) {
            List<PostFormVo> postFormVos = postService.findPostByClassId(classId, PageUtil.getPage(pageNumber, Constant.POST_PAGE_NUMBER, 0));
            if (postFormVos.size() != 0) {
                for (int i = 0; i < postFormVos.size(); i++) {
                    postFormVos.get(i).setPhotoUrl(postService.findUrlByPostId(postFormVos.get(i).getPostId()));
                }
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", postFormVos);
            } else
                return ResultUtil.getResult(Constant.SUCCESS, "查询为空", postFormVos);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/getPost",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findPostByPostId(@RequestParam("postId") Integer postId,@RequestParam("user_id") Integer userId) {
        if(postId>0) {
            postService.updatePostViews(postId);
            PostVo postVo = postService.findPostByPostId(postId);
            if (postVo != null) {
                postVo.setPhotoUrl(postService.findUrlByPostId(postVo.getPostId()));
                Date date=postVo.getPostCreateTime();
                Date now=new Date();
                long l=now.getTime()-date.getTime();
                long hour=l/(60*60*1000);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if(hour<24){
                    postVo.setTimeStatus(hour+"小时前");
                }
                else {
                    postVo.setTimeStatus(sdf.format(date));
                }
                if(userId!=null) {
                    Likes likes = new Likes();
                    likes.setLikesUserId(userId);
                    likes.setLikesType(false);
                    likes.setLikesTypeId(postVo.getPostId());
                    Integer likeResult = postService.findlikesByContent(likes);
                    if (likeResult != null)
                        postVo.setLiked(true);
                    else
                        postVo.setLiked(false);
                }
                Favorite favorite = new Favorite();
                favorite.setFavoriteUserId(userId);
                favorite.setFavoritePostId(postId);
                Integer favResult=postService.findFavoriteByContent(favorite);
                if(favResult!=null)
                    postVo.setFavorite(true);
                else
                    postVo.setFavorite(false);
                UserSimpleVo userSimpleVo= postService.findUsersByUserId(postVo.getPostUserId());
                if(userSimpleVo!=null){
                    postVo.setUserName(userSimpleVo.getNickname());
                    postVo.setHeadUrl(userSimpleVo.getHeadUrl());
                }
                return ResultUtil.getResult(Constant.SUCCESS, "查找成功", postVo);
            }
            return ResultUtil.getResult(Constant.SUCCESS, "查找为空", postVo);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);

    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/findReply")
    @ResponseBody
    public Map<String, Object> findReplyByPostId(@RequestParam("postId") Integer postId, @RequestParam("page") Integer pageNumber,@RequestParam("user_id") Integer userId){
        if (pageNumber > -1) {
            List<ReplyFormVo> replies = postService.findReplyByPostId(postId, PageUtil.getPage(pageNumber, Constant.REPLY_PAGE_NUMBER, 0));
            if (replies.size() != 0) {
                for(ReplyFormVo replyFormVo:replies){
                    Date date=replyFormVo.getReplyCreateTime();
                    Date now=new Date();
                    long l=now.getTime()-date.getTime();
                    long hour=l/(60*60*1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if(hour<24){
                        replyFormVo.setTimeStatus(hour+"小时前");
                    }
                    else {
                        replyFormVo.setTimeStatus(sdf.format(date));
                    }

                    Likes likes = new Likes();
                    likes.setLikesUserId(userId);
                    likes.setLikesType(true);
                    likes.setLikesTypeId(replyFormVo.getReplyId());
                    Integer result=postService.findlikesByContent(likes);
                    if(result!=null)
                        replyFormVo.setLiked(true);
                    else
                        replyFormVo.setLiked(false);
                    UserSimpleVo userSimpleVo= postService.findUsersByUserId(replyFormVo.getReplyUserId());
                    if(userSimpleVo!=null){
                        replyFormVo.setUserName(userSimpleVo.getNickname());
                        replyFormVo.setHeadUrl(userSimpleVo.getHeadUrl());
                    }
                }
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", replies);
            }
            else
                return ResultUtil.getResult(Constant.SUCCESS, "查询为空", replies);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPost(@ModelAttribute Post post, @RequestParam("user_id") Integer userId, @RequestParam("url") String url) {
        post.setPostDesc(post.getPostBody().substring(0, (Constant.POST_DESCRIPTION_LENGTH < post.getPostBody().length()) ? Constant.POST_DESCRIPTION_LENGTH : post.getPostBody().length()));//截取文章一部分作为描述
        List<String> urlList = new LinkedList<String>();
        //url以json数组格式传输，需要解析出来
        String[] temp = url.split("\"");
        for (int i = 0; i < temp.length; i++) {
            if (i % 2 != 0) {
                urlList.add(temp[i]);
            }
        }
        post.setPostUserId(userId);
        int result = postService.addPost(post);
        if (result != 0) {
            for (int i = 0; i < urlList.size(); i++) {
                int photoResult = postService.addPhotoUrl(post.getPostId(), urlList.get(i));
                if (photoResult == 0)
                    return ResultUtil.getResult(Constant.FAILURE, "图片添加失败", null);
            }
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", null);
        } else
            return ResultUtil.getResult(Constant.FAILURE, "内容添加失败", null);
    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addReply(@RequestBody Reply reply, @RequestParam("user_id") Integer userId) {
        reply.setReplyUserId(userId);
        int result = postService.addReply(reply);
        if (result != 0) {
            return ResultUtil.getResult(Constant.SUCCESS, "添加成功", null);
        } else
            return ResultUtil.getResult(Constant.FAILURE, "添加失败", null);
    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/addPostLike", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addLike(@RequestParam("user_id") Integer userId, @RequestParam("postId") Integer postId) {
        Likes likes = new Likes();
        likes.setLikesUserId(userId);
        likes.setLikesType(false);
        likes.setLikesTypeId(postId);
        int result = postService.addLike(likes);
        if (result != 0) {
            postService.updatePostLikes(postId);
            return ResultUtil.getResult(Constant.SUCCESS, "帖子点赞成功", null);
        }
        return ResultUtil.getResult(Constant.FAILURE, "已经点赞", null);
    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/addReplyLike", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addReplyLike(@RequestParam("user_id") Integer userId, @RequestParam("replyId") Integer replyId) {
        Likes likes = new Likes();
        likes.setLikesUserId(userId);
        likes.setLikesType(true);
        likes.setLikesTypeId(replyId);
        int result = postService.addLike(likes);
        if (result != 0) {
            postService.updateReplyLikes(replyId);
            return ResultUtil.getResult(Constant.SUCCESS, "回帖点赞成功", null);
        }
        return ResultUtil.getResult(Constant.FAILURE, "已经点赞", null);
    }

    @RequestMapping(value = "/findHomeTop")
    @ResponseBody
    public Map<String, Object> findHomeTop() {
        try {
            List<PostFormVo> postFormVos = postService.findHomeTop();

            if (postFormVos.size() != 0) {
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", postFormVos);
            }
            return ResultUtil.getResult(Constant.SUCCESS, "查询为空", postFormVos);
        }catch (Exception e){
            return ResultUtil.getResult(Constant.FAILURE,"查询失败",null);
        }
    }

    @RequestMapping(value = "/findClassTop")
    @ResponseBody
    public Map<String, Object> findClassTop(@RequestParam("classId") Integer classId) {
        if(classId>0) {
            List<PostFormVo> postFormVos = postService.findClassTop(classId);
            if (postFormVos.size() != 0) {
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", postFormVos);
            }
            return ResultUtil.getResult(Constant.SUCCESS, "查询为空", postFormVos);
        }
        return ResultUtil.getResult(Constant.FAILURE,"查询失败",null);
    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addFavorite(@RequestParam("user_id") Integer userId, @RequestParam("postId") Integer postId) {
        Favorite favorite = new Favorite();
        favorite.setFavoriteUserId(userId);
        favorite.setFavoritePostId(postId);
        int result = postService.addFavorite(favorite);
        if (result != 0)
            return ResultUtil.getResult(Constant.SUCCESS, "收藏成功", null);
        return ResultUtil.getResult(Constant.FAILURE, "已经收藏", null);
    }

    @RequestMapping(value = "/findFavorite")
    @ResponseBody
    public Map<String, Object> findFavorite(@RequestParam("user_id") Integer userId, @RequestParam("page") Integer pageNumber) {
        if (pageNumber > -1) {
            List<PostFormVo> list = postService.findFavoriteByUserId(userId, PageUtil.getPage(pageNumber, Constant.FAVORITE_PAGE_NUMBER, 0));
            if (list.size() != 0)
                return ResultUtil.getResult(Constant.SUCCESS, "查询成功", list);
            else
                return ResultUtil.getResult(Constant.SUCCESS, "查询为空", list);
        }
        return ResultUtil.getResult(Constant.FAILURE, "查询失败", null);
    }
}
