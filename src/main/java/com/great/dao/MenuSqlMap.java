package com.great.dao;

import com.great.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
    菜单对应的接口类
 @Mapper  不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
 */
@Mapper
public interface MenuSqlMap {
    public List<Menu>findMenuByRid(Integer rid);

    public List<Menu>findMenuByMid(Map map);

    public Integer deleteMenuRelation(Integer rid);

    public Integer insertMenuRelation(List<Map<String, Integer>> list);


}
