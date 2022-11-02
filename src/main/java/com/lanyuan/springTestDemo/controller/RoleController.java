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
    public String deleteRoleById(@PathVariable("id")long roleid){
        int i = roleService.deleteRoleById(roleid);
        if (i==0){
            return "删除失败";
        }else {
            return "成功删除" + i + "个角色";
        }
    }

    //修改根据主键更新role 不可以更新空值
    @RequestMapping("/edit")
    public String edit(Role role){
        int i = roleService.updateRole(role);
        return "修改成功";
    }

    //使用的是受保护的新增 数据中有null的话不会生成该字段部分的sql语句
    @RequestMapping("/addRole")
    public String  addRole(Role role){
        int i = roleService.insertRole(role);
        if (i==0){
            return "添加失败";
        }
        return "添加成功";
    }
}
