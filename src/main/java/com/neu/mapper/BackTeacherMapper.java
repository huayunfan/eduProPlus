package com.neu.mapper;

import com.neu.beans.Teacher;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

public interface BackTeacherMapper {
    public List<Teacher> findTeachers() throws SQLException;
    public int deleteTeacher(int tid) throws SQLException;
    public int addTeacher(Teacher teacher) throws SQLException;
    public Teacher findTeacherById(int tid) throws SQLException;
    public int editTeacher(Teacher teacher) throws SQLException;
}
