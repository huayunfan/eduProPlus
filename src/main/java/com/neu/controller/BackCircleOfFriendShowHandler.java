package com.neu.controller;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.beans.User;
import com.neu.service.BackGetAllMessageService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neu.util.FastDFSFile;
import com.neu.util.FileManager;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BackCircleOfFriendShowHandler {
	@Autowired
	private BackGetAllMessageService backGetAllMessageService;
	@RequestMapping(value = "/back/back_getAllMessage")
	@ResponseBody
	public List<Message> getAllMessage(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		List<Message> result = backGetAllMessageService.getAllMessage(user.getQid());
		for(Message r : result) {
			for(MessageImg m : ((Message) r).getMessageImg()) {
				System.out.println(request.getServletContext().getRealPath("/"));
//				File file = new File(request.getServletContext().getRealPath("/") + "upload/" + m.getImgurl());
//				System.out.println(file.getCanonicalPath());
//				FileInputStream fis = new FileInputStream(file);
//				BufferedImage bufferedImg = ImageIO.read(fis);
//				int imgWidth = bufferedImg.getWidth();
//				int imgHeight = bufferedImg.getHeight();
//				if(imgWidth > imgHeight) {
//					m.setFlag(0);
//				}else {
//					m.setFlag(1);
//				}
			}
		}
		System.out.println(result);
		System.out.println("测试");
		return result;
	}
	@RequestMapping(value = "/back/back_circleOfFriend_getPart")
	@ResponseBody
	public List<Address> getPart(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		return backGetAllMessageService.getPart(user.getQid());
	}
	
	@RequestMapping(value = "/back/back_circleOfFriend_setMessage")
	@ResponseBody
	public void  setMessage(String partChoose, 
							 String areaJs,
							 @RequestParam(value = "files", required = false) MultipartFile [] files,
							 HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		partChoose = URLDecoder.decode(partChoose,"utf-8");
		areaJs = URLDecoder.decode(areaJs,"utf-8");
		String pathOfService = request.getServletContext().getRealPath("/");
		String path;
		List<String> pathOfPicture = new ArrayList<>();
		for(MultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//			path =  (new Date().getTime()) + file.getOriginalFilename();
			String filename = System.currentTimeMillis() + file.getOriginalFilename();
			FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), filename.substring(filename.lastIndexOf(".")+1));
			NameValuePair[] meta_list = new NameValuePair[4];
			meta_list[0] = new NameValuePair("fileName", filename);
			meta_list[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
			meta_list[2] = new NameValuePair("fileExt", filename.substring(filename.lastIndexOf(".")+1));
			meta_list[3] = new NameValuePair("fileAuthor", "EduPro");
			String filePath = FileManager.upload(fastDFSFile,meta_list);
			pathOfPicture.add(filePath);
			System.out.println(filePath);
//			System.out.println(pathOfService + path);
//			file.transferTo(new File(pathOfService + "upload/" + path));
		}
		backGetAllMessageService.setMessage(user.getQid(), partChoose, areaJs, pathOfPicture);
	}
}
 