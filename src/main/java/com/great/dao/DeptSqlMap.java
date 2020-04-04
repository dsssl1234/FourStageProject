package com.great.dao;

import com.great.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptSqlMap {

    public User findById(Map map);
    public List<User> findAllUserByPage(Map map);
    public Integer findAllUserCount(Map map);
    public Integer addUser(User user);
    public Integer deleteUserInf(Integer uid);
    public Integer updateUserInf(User user);
    public Integer changeUserState(Map map);
    public Integer cUser(String account);
    public Integer registIncentives(Integer score);
    public Integer findRegistIncentives();

}
