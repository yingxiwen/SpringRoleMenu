package com.lanyuan.springTestDemo.controller;

import com.lanyuan.springTestDemo.entity.Role;
import com.lanyuan.springTestDemo.service.RoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/getRoleList")
    public List<Role> getRoleList(){
        return roleService.getRoleList();
    }

    @RequestMapping("/deleteRoleById/{id}")
    public int deleteRoleById(@PathVariable("id")long roleid){
        return roleService.deleteRoleById(roleid);
    }

    //修改根据主键更新role 不可以更新空值
    @RequestMapping("/edit")
    public int edit(Role role){
        return roleService.updateRole(role);
    }

    //使用的是受保护的新增 数据中有null的话不会生成该字段部分的sql语句
    @RequestMapping("/addRole")
    public int  addRole(Role role){
        return roleService.insertRole(role);
    }
}
