package com.lanyuan.springTestDemo.service;

import com.lanyuan.springTestDemo.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleList();

    public int deleteRoleById(long roleid);

    public int updateRole(Role role);

    public int insertRole(Role role);
}
