package com.ecare.web.service;

import com.ecare.web.pojo.Relations;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 李鹏飞 lipengfei19927@163.com
 */
public interface FamilyService {

    /**
     * 返回我直接关联的用户id
     *
     * @param userId 我的id
     * @return
     */
    List<Integer> myDirectRelationIds(Integer userId);

    List<Integer> myRelationIds(Integer userId);
}
