package com.neu.controller;

import com.neu.beans.Enterprise;
import com.neu.beans.Swiper;
import com.neu.beans.User;
import com.neu.service.BackCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BackCompanyHandler {
    @Autowired
    BackCompanyService companyService;

    @RequestMapping(value = "/back/get_company")
    @ResponseBody
    public Enterprise getCompany(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = ((User) session.getAttribute("user")).getQid();
        return companyService.findCompanyByQid(qid);
    }

    @RequestMapping(value = "/back/uploadcompanyvideo")
    @ResponseBody
    public Map<String, Object> upload(HttpServletRequest request, MultipartFile file) {
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/");
        File f = new File(path);
        String ppath = f.getParent();
        path = path + "/upload";
        Map<String, Object> map = new HashMap<>();
        if (!new File(path).exists()) {
            new File(path).mkdir();
        }
        File dest = new File(path, filename);
        try {
            file.transferTo(dest);
            map.put("code", 0);
            map.put("data", new Data(filename));
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", 1);
            return map;
        }
//        return "{\"code\":0,\"data\":{\"src\":\""+filename+"\"}}";
    }

    @RequestMapping(value = "/back/uploadmul")
    @ResponseBody
    public Map<String, Object> uploadmul(HttpServletRequest request, MultipartFile[] file) {
        List<Data> data = new ArrayList<>();
        String path = request.getServletContext().getRealPath("/");
        File f = new File(path);
        String ppath = f.getParent();
        path = path + "/upload";
        Map<String, Object> map = new HashMap<>();
        try {
            for (MultipartFile multipartFile : file) {
                String filename = System.currentTimeMillis() + multipartFile.getOriginalFilename();
                File dest = new File(path, filename);
                multipartFile.transferTo(dest);
                data.add(new Data(filename));
            }
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", 1);
            return map;
        }
        map.put("code", 0);
        map.put("data", data);
        return map;
    }

    @RequestMapping(value = "/back/editcompany")
    @ResponseBody
    public String editcompany(HttpServletRequest request, Enterprise enterprise, String img1, int img1id, String img2, int img2id, String img3, int img3id, String img4, int img4id) {
        HttpSession session = request.getSession();
        int qid = ((User) session.getAttribute("user")).getQid();
        enterprise.setQid(qid);
        System.out.println(img1 + "\n" + img2);
        List<Swiper> imgs = new ArrayList<>();
        imgs.add(new Swiper(img1id, img1));
        imgs.add(new Swiper(img2id, img2));
        imgs.add(new Swiper(img3id, img3));
        imgs.add(new Swiper(img4id, img4));
        if (companyService.editCompany(enterprise) && companyService.updateSwiper(imgs)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @RequestMapping(value = "/back/findswiper")
    @ResponseBody
    public List<Swiper> findswiper(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = ((User) session.getAttribute("user")).getQid();
        return companyService.findSwiper(qid);
    }

    class Data {
        String src;

        Data(String src) {
            this.src = src;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}
