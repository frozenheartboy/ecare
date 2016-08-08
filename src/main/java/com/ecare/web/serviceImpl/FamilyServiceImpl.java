package com.ecare.web.serviceImpl;

import com.ecare.web.mapper.RelationsMapper;
import com.ecare.web.pojo.Relations;
import com.ecare.web.service.FamilyService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李鹏飞 lipengfei19927@163.com
 * @datetime 2016-8-3 9:11:49
 */
@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private RelationsMapper relationsMapper;

    public List<Integer> myDirectRelationIds(Integer userId) {
        List<Integer> directRelationsIds = relationsMapper.selectByUserId(userId);
        return directRelationsIds;
    }

    public List<Integer> myRelationIds(Integer userId) {
        return relationsMapper.selectByDirectUserIds(userId);
    }
}
