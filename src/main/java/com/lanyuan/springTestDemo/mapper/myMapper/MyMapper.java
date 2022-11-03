package com.lanyuan.springTestDemo.mapper.myMapper;

import com.lanyuan.springTestDemo.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MyMapper {

    //根据用户id查找权限列表 包括层级关系
    public List<Menu> selectMenuListByUserId(long userid);

    //查询指定菜单的子菜单
    public List<Menu> selectChildListByMenuId(long parentid);

    //给新注册的用户默认绑定id为2的角色
    public int insertRoleToUserDefault(long userid);

    //查询所有顶级菜单
    public List<Menu> selectParentMenuList();

    //根据角色id删除绑定菜单的记录
    public int deleteRoleMenuByRoleid(long roleid);

    //给角色分配权限
    public int insertRoleMenuByRoleidAndMenuid(Map<String,Object> params);

    //通过用户编号删除用户与角色的绑定
    public int deleteUserRoleByUserId(long userid);

    //给用户分配角色
    public int insertUserRoleByUseridAndRoleid(Map<String,Object> params);

    //
    public int deleteUserFromUserRole(long userid);


    public int deleteRoleFromRoleMenu(long roleid);

    public int deleteRoleFromUserRole(long roleid);
}
