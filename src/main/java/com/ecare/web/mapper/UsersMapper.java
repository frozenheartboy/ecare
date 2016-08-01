package com.ecare.web.mapper;

import com.ecare.web.pojo.Users;
import com.ecare.web.vo.UserSimpleVo;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    UserSimpleVo selectSimpleByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}