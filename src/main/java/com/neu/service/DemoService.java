package com.neu.service;

import com.neu.beans.Lesson;

import java.util.List;

public interface DemoService {
    public List<Lesson> findLessons();
    public List<String> findlessonType();
}
