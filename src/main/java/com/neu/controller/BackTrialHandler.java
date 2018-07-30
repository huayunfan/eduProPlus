package com.neu.controller;

import com.neu.beans.FreeListen;
import com.neu.beans.User;
import com.neu.service.BackTrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BackTrialHandler {
    @Autowired
    BackTrialService trialService;

    @RequestMapping(value = "/back/findtrial")
    @ResponseBody
    public List<FreeListen> findquality(HttpServletRequest request, @RequestParam int currectPage) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int pageStart = (currectPage - 1) * 10;
		int pageNumber = 10;
        return trialService.findtrial(user.getQid(), pageStart, pageNumber);
    }

    @ResponseBody
    @RequestMapping(value = "/back/findtrialbyid")
    public FreeListen findtrialbyid(int id) {
        return trialService.fintrialbyid(id);
    }

    @RequestMapping(value = "/back/deletetrial")
    @ResponseBody
    public String deletetrial(int id) {
        if (trialService.deleteTrial(id)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @RequestMapping(value = "/back/edittrial")
    @ResponseBody
    public String edittrial(FreeListen freeListen) {
        if (trialService.editTrial(freeListen)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @RequestMapping(value = "/back/addtrial")
    @ResponseBody
    public String addtrial(HttpServletRequest request, FreeListen freeListen) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        freeListen.setQid(user.getQid());
        freeListen.setStatus("进行中");
        freeListen.setPubtime(new Date());
        if (trialService.addTrial(freeListen)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }
    
    @RequestMapping(value = "/back/getPageNumber")
    @ResponseBody
    public int getPageNumber(HttpServletRequest request) throws Exception {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
		// TODO Auto-generated method stub
		int allPageNumber = trialService.getPageNumber(user.getQid());
		if(allPageNumber % 10 == 0) {
			return allPageNumber / 10;
		}else {
			return (allPageNumber / 10) + 1;
		}
	}
}
