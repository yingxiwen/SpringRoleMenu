package com.lanyuan.springTestDemo.controller;

import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.service.MenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    //获取所有权限 具有层级关系
    @RequestMapping("/getMenuList")
    public List<Menu> getMenuList(){
        return menuService.getParentMenuList();
    }

    //获取所有权限 没有层级关系
    @RequestMapping("/getMenuListNotChild")
    public List<Menu> getMenuListNotChild(){
        return menuService.getMenuListNotChild();
    }

    //给角色分配权限
    @RequestMapping("/giveMenuToRole")
    public int giveMenuToRole(Long roleid,Long[] menuid){
        if (roleid==null){
            return 0;
        }
        return menuService.insertRoleMenu(roleid,menuid);
    }

    //给用户分配角色
    @RequestMapping("/giveRoleToUser")
    public int giveRoleToUser(Long userid,Long roleid){
        if (userid==null||roleid==null){
            return 0;
        }
        return menuService.insertUserRole(userid,roleid);
    }
}
