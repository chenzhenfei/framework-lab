package com.tsshare.lab02.web.role;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tsshare.lab02.entity.role.Role;
import com.tsshare.lab02.service.role.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 控制器
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-06-09
 */
@Api(tags = {"角色表"})
@RestController
@Slf4j
@RequestMapping("/role")
public class RoleController{

    @Autowired
    private IRoleService roleService;


    @ApiOperation(value = "新增角色表")
    @PostMapping(value="add")
    public int add(@RequestBody Role role){
        return roleService.add(role);
    }

    @ApiOperation(value = "删除角色表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return roleService.delete(id);
    }

    @ApiOperation(value = "更新角色表")
    @PutMapping(value="update")
    public int update(@RequestBody Role role){
        return roleService.updateData(role);
    }

    @ApiOperation(value = "查询角色表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping
    public IPage<Role> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return roleService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询角色表")
    @GetMapping("{id}")
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);
    }

}
