package com.ecare.web.mapper;

import com.ecare.web.pojo.Relations;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 李鹏飞 lipengfei19927@163.com
 */
public interface RelationsMapper {

    List<Integer> selectByUserId(Integer userId);

    List<Integer> selectByDirectUserIds(Integer userId);
}
