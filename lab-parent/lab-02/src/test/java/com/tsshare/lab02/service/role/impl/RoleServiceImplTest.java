package com.tsshare.lab02.service.role.impl;

import com.tsshare.lab02.entity.role.Role;
import com.tsshare.lab02.service.role.IRoleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class RoleServiceImplTest {
    @Autowired
    private IRoleService roleService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        Role role = roleService.findById(1L);
        System.out.println(role.getStatus());
        role.setStatus("1");

        Role roleR = roleService.findById(1L);
        System.out.println(roleR.getStatus());

        Assert.isTrue(role.getStatus().equals(roleR.getStatus()), "修改后的status 与重新查的状态是一致的，并且是修改后的");
    }
}