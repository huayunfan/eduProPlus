package com.neu.mapper;

import com.neu.beans.Lesson;
import com.neu.beans.LessonBranch;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BackQualityMapper {
    public List<Lesson> findQuality(@Param("qid") int qid,
    								@Param("pageStart") int pageStart,
    								@Param("pageNumber") int pageNumber) throws SQLException;
    public int deleteQuality(int lid) throws SQLException;
    public Lesson finQualityById(int lid) throws SQLException;

    public List<Integer> findBranchIds(int lid) throws SQLException;

    public int addlessonbranch(LessonBranch lessonBranch) throws SQLException;
    public List<String> findCategory(int qid) throws SQLException;

    public int deletelessonbranch(int lid) throws SQLException;

    public List<String> findBranchNames(int lid) throws SQLException;

    public int addQuality(Lesson lesson) throws SQLException;

    public int editQuality(Lesson lesson) throws SQLException;

    public int getPageNumber(@Param("qid") int qid) throws Exception;
}
