package com.neu.service;

import java.util.List;


import com.neu.beans.FreeListen;

public interface BackGetFreeListenBookService {
	public int getPageNumber() throws Exception;
	public List<FreeListen> getfreeListenBookByeInput(int qid, int pageStart, int pageNumber, String titleKey, String listenState, String listenStartTime, String listenEndTime) throws Exception;
	public void setState(int book_id) throws Exception;
}
