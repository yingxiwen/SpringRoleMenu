package com.lanyuan.springTestDemo.controller;


import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.entity.User;
import com.lanyuan.springTestDemo.service.UserService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //查询所有用户并返回
    @RequestMapping("/getUserList")
    public List<User> getUserList(){
       return userService.getUserList();
    }


    @RequestMapping("/deleteUserById/{userid}")
    public int deleteUserById(@PathVariable("userid")long userid){
        return userService.deleteUserById(userid);
    }

    /*
    注册用户
    1 如果用户名和密码有一个为空值 返回null
    2 如果用户名已存在 则返回null
    3 创建成功 就返回创建的用户对象
     */
    @RequestMapping("/register")
    public User register(User user){
        if (user.getUsername()==null||user.getUsername().trim().equals("")||user.getPassword()==null||user.getPassword().trim().equals("")){
            return null;
        }
        List<User> users = userService.selectUserByUsername(user.getUsername());
        if (users.size()>0){
            return null;
        }
        userService.insertUser(user);
        User user1 = userService.selectUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user1!=null){
            userService.insertRoleToUserDefault(user1.getId());
        }
        return user1;
    }

    @RequestMapping("/login")
    public User login(User user, HttpServletRequest request, String checkcode){
        System.out.println("登录请求的session是"+request.getSession().getId());
        ServletContext servletContext = request.getSession().getServletContext();
        Object login_code = servletContext.getAttribute("login_code");
        if (login_code==null){
            return null;
        }
        if (!login_code.toString().equalsIgnoreCase(checkcode)){
            return null;
        }
        if (user.getUsername()==null||user.getPassword()==null){
            return null;
        }else{
            return userService.selectUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        }
    }

    @RequestMapping("/edit")
    public int edit(User user){
        return userService.updateUser(user);
    }

    //查询用户所拥有的权限 包括层级关系
    @RequestMapping("/getMenuList")
    public List<Menu> getMenuList(User user){
        if (user.getId()==null){
            return null;
        }
        List<Menu> menus = userService.selectMenuByUserId(user.getId());
        return menus;
    }


}
