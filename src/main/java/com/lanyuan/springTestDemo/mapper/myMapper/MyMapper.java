package com.lanyuan.springTestDemo.mapper.myMapper;

import com.lanyuan.springTestDemo.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MyMapper {
    public List<Menu> selectMenuListByUserId(long userid);

    public List<Menu> selectChildListByMenuId(long parentid);

    public int insertRoleToUserDefault(long userid);

    public List<Menu> selectParentMenuList();

    public int deleteRoleMenuByRoleid(long roleid);

    public int insertRoleMenuByRoleidAndMenuid(Map<String,Object> params);

    public int deleteUserRoleByUserId(long userid);

    public int insertUserRoleByUseridAndRoleid(Map<String,Object> params);

    public int deleteUserFromUserRole(long userid);
}
