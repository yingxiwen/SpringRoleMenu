package com.lanyuan.springTestDemo.service;

import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public int deleteUserById(long id);

    public int updateUser(User user);

    public User selectUserByUsernameAndPassword(String username,String password);

    public List<Menu> selectMenuByUserId(long userid);

    public int insertUser(User user);

    public List<User> selectUserByUsername(String username);

    public int insertRoleToUserDefault(long id);
}
