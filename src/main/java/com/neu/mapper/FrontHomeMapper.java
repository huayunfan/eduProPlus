package com.neu.mapper;

import java.util.List;

import com.neu.beans.FreeListen;
import com.neu.beans.Lesson;
import com.neu.beans.Swiper;

public interface FrontHomeMapper {
	public List<Swiper> getHomeImg(int qid) throws Exception;
	public List<Lesson> getnewTwoLesson(int qid) throws Exception;
	public List<FreeListen> getNewTwoFreeListen(int qid) throws Exception;
}
