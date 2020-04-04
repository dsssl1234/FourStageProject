package com.great.dao;

import com.great.entity.DocumentType;
import com.great.entity.MyScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
    菜单对应的接口类
 @Mapper  不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
 */
@Mapper
public interface DocumentTypeSqlMap {

    //查找所有的文档类型
    public List<DocumentType> findDocumentType();
    public List<MyScore> findMyScore(Map map);
    public Integer findMyScoreCount(Integer uid);
    public Integer findTypeCount(Map map);
    public List<DocumentType> findType(Map map);
    public Integer deleteType(Integer uid);
    public Integer updateType(DocumentType documentType);
    public Integer addType(DocumentType documentType);
    public Integer changeUserScore(Map map);
    public Integer typeScore(String typename);
    public Integer insertScoreRecord(MyScore myScore);
    public Integer  findUserScore(Integer userid);
}
