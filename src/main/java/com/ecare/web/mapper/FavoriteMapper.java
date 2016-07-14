package com.ecare.web.mapper;

import com.ecare.web.pojo.Favorite;

public interface FavoriteMapper {
    int deleteByPrimaryKey(Integer favoriteid);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Integer favoriteid);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}