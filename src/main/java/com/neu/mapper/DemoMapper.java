package com.neu.mapper;

import com.neu.beans.Lesson;
import com.neu.beans.Refund;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {
    public List<Lesson> findLessons() throws Exception;
    public List<Refund> findOK();
}
