package com.lanyuan.springTestDemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.entity.User;
import com.lanyuan.springTestDemo.entity.UserExample;
import com.lanyuan.springTestDemo.mapper.UserMapper;
import com.lanyuan.springTestDemo.mapper.myMapper.MyMapper;
import com.lanyuan.springTestDemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MyMapper myMapper;

    @Override
    public List<User> getUserList() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public PageInfo<User> getUserList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<User> users = userMapper.selectByExample(null);
        return new PageInfo<User>(users,5);
    }

    @Override
    public int deleteUserById(long id) {
        myMapper.deleteUserFromUserRole(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        if (username==null||password==null||username.trim().equals("")||password.trim().equals("")){
            return null;
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        User user=null;
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0){
            user=users.get(0);
        }

        return user;
    }

    @Override
    public List<Menu> selectMenuByUserId(long userid) {
        return myMapper.selectMenuListByUserId(userid);
    }

    @Override
    public int insertUser(User user) {
        int i = userMapper.insertSelective(user);


        return i;
    }

    @Override
    public List<User> selectUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public int insertRoleToUserDefault(long id) {
        return myMapper.insertRoleToUserDefault(id);
    }
}
