package com.lanyuan.springTestDemo.mapper;

import com.lanyuan.springTestDemo.entity.Role;
import com.lanyuan.springTestDemo.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long roleid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long roleid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}