package com.ecare.web.task;

import com.ecare.web.mapper.ClassMapper;
import com.ecare.web.mapper.PostMapper;
import com.ecare.web.pojo.Class;
import com.ecare.web.vo.Constant.Constant;
import com.ecare.web.vo.PostFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by L on 2016/7/25.
 */
@Component
public class HomeTopTask {

    @Autowired
    ClassMapper classMapper;
    @Autowired
    PostMapper postMapper;

    @Scheduled(cron = "0 0 0 * * *")
    public void update() {
        System.out.print("1");
        List<Integer> postIdList=new LinkedList<Integer>();
        List<Integer> integerList=classMapper.selectAllClassId();
        for(int classId:integerList){
            List<PostFormVo> postFormVolist=postMapper.selectClassTop(classId, Constant.CLASS_TOP_NUMBER);
            for(PostFormVo post:postFormVolist){
                postIdList.add(post.getPostId());
            }
        }
        postMapper.initAllPostActiveNumber();
        for(int i:postIdList){
            postMapper.initPostActiveNumber(i);
        }


    }

}
