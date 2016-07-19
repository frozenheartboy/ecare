package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.*;
import com.ecare.web.pojo.*;
import com.ecare.web.pojo.Class;
import com.ecare.web.service.PostService;
import com.ecare.web.vo.PageVo;
import com.ecare.web.vo.PostFormVo;
import com.ecare.web.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by L on 2016/7/13.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private LikesMapper likesMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private PhotoMapper photoMapper;

    public List<Class> findAllClass(PageVo page) {
        return classMapper.selectAll(page.getPageStart(), page.getPageSize());
    }

    public Class findClassByClassId(int classId) {
        return classMapper.selectByPrimaryKey(classId);
    }

    public int updateClassViews(int classId) {
        return classMapper.updateClassViews(classId);
    }

    public List<PostFormVo> findPostByClassId(int classId, PageVo page) {
        return postMapper.selectByClassId(classId, page.getPageStart(), page.getPageSize());
    }

    public int updatePostViews(int postId) {
        return postMapper.updatePostViews(postId);
    }

    public PostVo findPostByPostId(int postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    public List<Reply> findReplyByPostId(int postId, PageVo page) {
        return replyMapper.selectByPostId(postId, page.getPageStart(), page.getPageSize());
    }

    public int addPost(Post post) {
        return postMapper.insertSelective(post);
    }

    public int addReply(Reply reply) {
        return replyMapper.insertSelective(reply);
    }

    public int addLike(Likes likes) {
        Integer result = likesMapper.selectByContent(likes);
        if (result == null)
            return likesMapper.insertSelective(likes);
        else
            return 0;
    }

    public int addFavorite(Favorite favorite) {
        Integer result = favoriteMapper.selectByContent(favorite);
        if (result == null)
            return favoriteMapper.insertSelective(favorite);
        else
            return 0;
    }

    public List<PostFormVo> findFavoriteByUserId(int userId, PageVo page) {
        List<Integer> lists = favoriteMapper.selectByUserId(userId);
        List<PostFormVo> postFormVoList = new LinkedList<PostFormVo>();
        for (int i = page.getPageStart(); i < lists.size() && i < page.getPageStart() + page.getPageSize(); i++) {
            PostFormVo postFormVo = postMapper.selectFormByPrimaryKey(lists.get(i));
            if (postFormVo != null) {
                postFormVoList.add(postFormVo);
            }
        }
        return postFormVoList;
    }

    public int addPhotoUrl(int postId, String url) {
        Photo photo = new Photo();
        photo.setPhotoPostId(postId);
        photo.setPhotoUrl(url);
        return photoMapper.insertSelective(photo);
    }

    public List<String> findUrlByPostId(int postId) {
        return photoMapper.selectByPostId(postId);
    }

}
