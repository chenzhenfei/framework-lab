package com.tsshare.lab11.service;

import com.tsshare.lab11.entity.UserTb;
import com.tsshare.lab11.repository.UserTbMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenzhenfei
 * @title: UserService
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/10/2622:02
 */
@Service
public class UserService {
    @Autowired
    private UserTbMapper userTbMapper;

    public int insert(UserTb userTb){
        int insert = userTbMapper.insertSelective(userTb);
        return insert;
    }

    public UserTb selectByKey(long id) {
        // 强制路由主库
        HintManager.getInstance().setMasterRouteOnly();
        UserTb userTb = userTbMapper.selectByPrimaryKey(id);
        return userTb;
    }
}
