package com.ecare.web.mapper;

import com.ecare.web.pojo.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {
    int deleteByPrimaryKey(Integer favoriteId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Integer favoriteId);

    List<Integer> selectByUserId(Integer userId);

    Integer selectByContent(Favorite record);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}