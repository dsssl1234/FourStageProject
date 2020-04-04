package com.great.dao;

import com.great.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogSqlMap {


    public Integer addLog(SystemLog systemLog);




}
