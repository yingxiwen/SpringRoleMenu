package com.lanyuan.springTestDemo.service;

import com.lanyuan.springTestDemo.entity.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> getParentMenuList();

    public List<Menu> getMenuListNotChild();

    public int insertRoleMenu(long roleid,Long[] menuid );

    public int insertUserRole(Long userid,Long roleid );

}
