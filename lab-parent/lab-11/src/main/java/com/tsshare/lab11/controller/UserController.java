package com.tsshare.lab11.controller;

import com.tsshare.lab11.entity.UserTb;
import com.tsshare.lab11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenzhenfei
 * @title: UserController
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/10/2622:00
 */
@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public int save(@RequestBody UserTb userTb){
        int insert = userService.insert(userTb);
        return insert;
    }

    @GetMapping(value = "/{id}")
    public UserTb save(@PathVariable(value = "id") long id){
        UserTb userTb = userService.selectByKey(id);
        return userTb;
    }
}
