package com.neu.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.mapper.BackGetAllMessageMapper;
import com.neu.service.BackGetAllMessageService;
@Service
public class BackGetAllMessageServiceImpl implements BackGetAllMessageService {
	@Autowired
	private BackGetAllMessageMapper backGetAllMessageMapper;
	@Override
	public List<Message> getAllMessage(int qid) throws Exception {
		// TODO Auto-generated method stub
		return backGetAllMessageMapper.getAllMessage(qid);
	}
	@Override
	public List<Address> getPart(int qid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ceshi_getPart");
		return backGetAllMessageMapper.getPart(qid);
	}
	@Override
	public void setMessage(int qid, String partChoose, String areaJs, List<String> pathOfPicture) throws Exception {
		// TODO Auto-generated method stub
		int branchid = backGetAllMessageMapper.getBranchId(partChoose);
		int mid = backGetAllMessageMapper.getNewMid();
		backGetAllMessageMapper.setMessage(mid, areaJs, qid, branchid);
		for(String path : pathOfPicture) {
			int id = backGetAllMessageMapper.getNewId();
			backGetAllMessageMapper.setMessageImg(id, mid, path);
		}
	}
}
