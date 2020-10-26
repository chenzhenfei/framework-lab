package com.tsshare.lab11.repository;

import com.tsshare.lab11.entity.UserTb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}