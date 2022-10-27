package com.lanyuan.springTestDemo.mapper.myMapper;

import com.lanyuan.springTestDemo.entity.Menu;

import java.util.List;

public interface MyMapper {
    public List<Menu> selectMenuListByUserId(long userid);

    public List<Menu> selectChildListByMenuId(long parentid);

    public int insertRoleToUserDefault(long userid);
}
