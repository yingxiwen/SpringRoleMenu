package com.lanyuan.springTestDemo.service.impl;

import com.lanyuan.springTestDemo.entity.Menu;
import com.lanyuan.springTestDemo.mapper.MenuMapper;
import com.lanyuan.springTestDemo.mapper.myMapper.MyMapper;
import com.lanyuan.springTestDemo.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl  implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MyMapper myMapper;

    @Override
    public List<Menu> getParentMenuList() {
        return myMapper.selectParentMenuList();
    }

    @Override
    public List<Menu> getMenuListNotChild() {
        return menuMapper.selectByExample(null);
    }

    @Override
    public int insertRoleMenu(long roleid, Long[] menuid) {
        myMapper.deleteRoleMenuByRoleid(roleid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("roleid",roleid);
        map.put("menuid",menuid);
        if (menuid!=null&&menuid.length>0){
            return myMapper.insertRoleMenuByRoleidAndMenuid(map);
        }else {
            return 0;
        }
    }

    @Override
    public int insertUserRole(Long userid, Long roleid) {
        myMapper.deleteUserRoleByUserId(userid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",userid);
        map.put("roleid",roleid);

        if (userid!=null&&roleid!=null){
            return myMapper.insertUserRoleByUseridAndRoleid(map);
        }else {
            return 0;
        }
    }
}
