package com.great.dao;

import com.great.entity.Document;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
    菜单对应的接口类
 @Mapper  不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
 */
@Mapper
public interface DocumentSqlMap {

    public Integer insertInfByUid(Document document);

    public List<Document> findDocumentByUid(Map map);

    public Integer findDocumentCount(Map map);

    public List<Document> findDocumentRecord(Map map);

    public Integer findDocumentRecordCount(Map map);

    public Integer deleteDocumentInf(Integer did);

    public Integer changeDocumentState(Map map);

    public Document findDocument(Integer did);

    public void newDownCount(Map map);



}
