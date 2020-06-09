package com.tsshare.lab02.service.role;

import com.tsshare.lab02.entity.role.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author CodeGenerator
 * @since 2020-06-09
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询角色表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Role>
     */
    IPage<Role> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加角色表
     *
     * @param role 角色表
     * @return int
     */
    int add(Role role);

    /**
     * 删除角色表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改角色表
     *
     * @param role 角色表
     * @return int
     */
    int updateData(Role role);

    /**
     * id查询数据
     *
     * @param id id
     * @return Role
     */
    Role findById(Long id);
}
