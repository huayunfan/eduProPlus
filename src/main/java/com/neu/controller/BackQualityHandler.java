package com.neu.controller;

import com.neu.beans.Lesson;
import com.neu.beans.LessonBranch;
import com.neu.beans.User;
import com.neu.service.BackQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Controller
public class BackQualityHandler {
    @Autowired
    BackQualityService qualityService;

    @RequestMapping(value = "/back/findcategory")
    @ResponseBody
    public List<String> findcategory(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        return qualityService.findCategory(user.getQid());
    }

    @RequestMapping(value = "/back/findbranchsbylid")
    @ResponseBody
    public List<Integer> findbranches(int lid) {
        return qualityService.findBranchIds(lid);
        
    }

    @RequestMapping(value = "/back/findbranchsnamebylid")
    @ResponseBody
    public List<String> findbranchesName(int lid) {
        return qualityService.findBranchNames(lid);
    }
    @ResponseBody
    @RequestMapping(value = "/back/findquality")
    public List<Lesson> findquality(HttpServletRequest request,
    								@RequestParam int currectPage) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int pageStart = (currectPage - 1) * 10;
		int pageNumber = 10;
        return qualityService.findQuanlity(user.getQid(), pageStart, pageNumber);
    }

    @ResponseBody
    @RequestMapping(value = "/back/findqualitybyid")
    public Lesson findqualitybyid(int lid) {
        return qualityService.finQualityById(lid);
    }


    @RequestMapping(value = "/back/deletequality")
    @ResponseBody
    public String deleteQuality(int lid) {
        if (qualityService.deleteQuanlity(lid)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @RequestMapping(value = "/back/editquality")
    @ResponseBody
    public String editquality(Lesson lesson, String branch) {
        System.out.println(branch);
        StringTokenizer s = new StringTokenizer(branch, ",");
        List<Integer> t = new ArrayList<>();
        while (s.hasMoreElements()) {
            t.add(Integer.valueOf(s.nextToken()));
        }
        if (qualityService.editQuality(lesson, t)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @RequestMapping(value = "/back/lessonbranch")
    @ResponseBody
    public String lessonbranch(@RequestBody int[] branches) {
        qualityService.deletelessonbranch(branches[branches.length - 1]);
        for (int i = 0; i < branches.length - 1; i++) {
            LessonBranch lessonBranch = new LessonBranch();
            lessonBranch.setBranchid(branches[i]);
            lessonBranch.setLid(branches[branches.length - 1]);
            System.out.println(branches[i] + " " + branches[branches.length - 1]);
            qualityService.addlessonbranch(lessonBranch);
        }
//        if (qualityService.editQuality(lesson)) {
        return "{\"result\":\"success\"}";
//        } else return "{\"result\":\"failed\"}";
    }
    @RequestMapping(value = "/back/addquality")
    @ResponseBody
    public String addquality(HttpServletRequest request, Lesson lesson, String branch) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        lesson.setQid(user.getQid());
        lesson.setStatus("进行中");
        lesson.setPubtime(new Date());
        System.out.println(branch);
        StringTokenizer s = new StringTokenizer(branch, ",");
        List<Integer> t = new ArrayList<>();
        while (s.hasMoreElements()) {
            t.add(Integer.valueOf(s.nextToken()));
        }
        int lid = qualityService.addQuality(lesson, t);
        System.out.println(lid);
        if (lid > 0) {
            return "{\"result\":\"success\",\"lid\":\"" + lid + "\"}";
        } else return "{\"result\":\"failed\"}";
    }
    @RequestMapping(value = "/back/getQualityPageNumber")
    @ResponseBody
    public int getQualityPageNumber(HttpServletRequest request) throws Exception{
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
    	int allPageNumber = qualityService.getPageNumber(user.getQid());
		if(allPageNumber % 10 == 0) {
			return allPageNumber / 10;
		}else {
			return (allPageNumber / 10) + 1;
		}
    }
}
