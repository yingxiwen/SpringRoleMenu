package com.lanyuan.springTestDemo.service.impl;

import com.lanyuan.springTestDemo.entity.Role;
import com.lanyuan.springTestDemo.mapper.RoleMapper;
import com.lanyuan.springTestDemo.mapper.myMapper.MyMapper;
import com.lanyuan.springTestDemo.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MyMapper myMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public int deleteRoleById(long roleid) {
        int i = roleMapper.deleteByPrimaryKey(roleid);
        return i;
    }

    @Override
    public int updateRole(Role role) {
        int i = roleMapper.updateByPrimaryKeySelective(role);
        return i;
    }

    @Override
    public int insertRole(Role role) {
        int i = roleMapper.insertSelective(role);
        return i;
    }
}
