package com.lanyuan.springTestDemo.service;

import com.github.pagehelper.PageInfo;
import com.lanyuan.springTestDemo.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleList();

    public PageInfo<Role> getRoleList(Integer pageIndex,Integer pageSize);

    public int deleteRoleById(long roleid);

    public int updateRole(Role role);

    public int insertRole(Role role);
}
