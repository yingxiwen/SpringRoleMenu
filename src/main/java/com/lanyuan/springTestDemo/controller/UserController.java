package com.lanyuan.springTestDemo.controller;


import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.entity.User;
import com.lanyuan.springTestDemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

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
        return userService.selectUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @RequestMapping("/login")
    public User login(User user){
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

    @RequestMapping("/getMenuList")
    public List<Menu> getMenuList(User user){
        if (user.getId()==null){
            return null;
        }
        List<Menu> menus = userService.selectMenuByUserId(user.getId());
        return menus;
    }


}
