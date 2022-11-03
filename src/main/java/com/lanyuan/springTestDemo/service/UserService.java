package com.lanyuan.springTestDemo.service;

import com.github.pagehelper.PageInfo;
import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public PageInfo<User> getUserList(Integer pageIndex,Integer pageSize);

    public int deleteUserById(long id);

    public int updateUser(User user);

    public User selectUserByUsernameAndPassword(String username,String password);

    public List<Menu> selectMenuByUserId(long userid);

    public int insertUser(User user);

    public List<User> selectUserByUsername(String username);

    public int insertRoleToUserDefault(long id);
}
