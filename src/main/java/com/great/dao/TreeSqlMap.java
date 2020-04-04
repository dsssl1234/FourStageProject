package com.great.dao;

import com.great.entity.Tree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    菜单对应的接口类
 */
@Mapper
public interface TreeSqlMap {
//    public List<Tree> fatherMenuByRid(Integer rid);

    public List<Tree>allMenuByRid();

    public List<Tree>allMidByRid(Integer rid);
}
