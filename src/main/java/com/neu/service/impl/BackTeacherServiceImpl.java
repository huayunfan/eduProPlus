package com.neu.service.impl;

import com.neu.beans.Teacher;
import com.neu.mapper.BackTeacherMapper;
import com.neu.service.BackTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
public class BackTeacherServiceImpl implements BackTeacherService {
    @Autowired
    BackTeacherMapper teacherMapper;
    @Override
    public List<Teacher> findTeachers() {
        try {
            return teacherMapper.findTeachers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    @Override
    public boolean deleteTeacher(int tid) {
        try {
            return teacherMapper.deleteTeacher(tid) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Transactional
    @Override
    public boolean addTeacher(Teacher teacher) {
        try {
            return teacherMapper.addTeacher(teacher)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Teacher findTeacherBiId(int tid) {
        try {
            return teacherMapper.findTeacherById(tid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editTeacher(Teacher teacher) {
        try {
            return teacherMapper.editTeacher(teacher)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
