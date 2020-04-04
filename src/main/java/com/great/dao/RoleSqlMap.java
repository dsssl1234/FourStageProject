package com.great.dao;

import com.great.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleSqlMap {


    public List<Role> findAllRoleByPage(Map map);
    public Integer findAllRoleCount();



}
