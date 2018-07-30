package com.neu.service;

import java.util.List;

import com.neu.beans.Teacher;

public interface FrontTeacherService {

	List<Teacher> findTeacher(int qid) throws Exception;

}
