package com.neu.mapper;

import com.neu.beans.FreeListen;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BackTrialMapper {
    public List<FreeListen> findTrial(@Param("qid") int qid,
    								  @Param("pageStart") int pageStart,
    								  @Param("pageNumber") int pageNumber) throws SQLException;

    public FreeListen findTrialById(int id) throws SQLException;

    public int deleteTrial(int id) throws SQLException;

    public int addTrial(FreeListen freeListen) throws SQLException;

    public int editTrial(FreeListen freeListen) throws SQLException;
    
    public int getPageNumber(@Param("qid") int qid) throws Exception;
}
