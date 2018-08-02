package com.neu.controller;

import com.neu.beans.Teacher;
import com.neu.beans.User;
import com.neu.service.BackTeacherService;
import com.neu.util.FastDFSFile;
import com.neu.util.FileManager;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BackTeacherHandler {
    @Autowired
    BackTeacherService teacherService;

    @ResponseBody
    @RequestMapping(value = "/back/findteachers")
    public List<Teacher> findteachers() {
        return teacherService.findTeachers();
    }

    @RequestMapping(value = "/back/deleteteacher")
    @ResponseBody
    public String deleteTeacher(int tid) {
        if (teacherService.deleteTeacher(tid)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    class Update {
        private int code;
        private Data data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        class Data {
            private String src;

            public Data(String src) {
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

    @RequestMapping(value = "/back/teacherupload")
    @ResponseBody
    public Update upload(HttpServletRequest request, MultipartFile file) {
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
//        String path = request.getServletContext().getRealPath("/");
//        File f = new File(path);
//
//        String ppath = f.getParent();
//        path = path + "/upload";
        Update u = new Update();
//        if (!new File(path).exists()) {
//            new File(path).mkdir();
//        }
//        File dest = new File(path, filename);
        try {
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), filename.substring(filename.lastIndexOf(".")+1));
            NameValuePair[] meta_list = new NameValuePair[4];
            meta_list[0] = new NameValuePair("fileName", filename);
            meta_list[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
            meta_list[2] = new NameValuePair("fileExt", filename.substring(filename.lastIndexOf(".")+1));
            meta_list[3] = new NameValuePair("fileAuthor", "EduPro");
            String filePath = FileManager.upload(fastDFSFile,meta_list);
//            file.transferTo(dest);
            u.setCode(0);
            u.setData(u.new Data(filePath));
            System.out.println(filePath);
            return u;
        } catch (IOException e) {
            e.printStackTrace();
            u.setCode(1);
            return u;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/back/addteacher")
    public String addteacher(HttpServletRequest request, Teacher teacher) {
        System.out.println(teacher.getTname());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        teacher.setQid(user.getQid());
        if (teacherService.addTeacher(teacher)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/back/editteacher")
    public String editteacher(Teacher teacher) {
        System.out.println(teacher.getTname() + teacher.getTid());
        if (teacherService.editTeacher(teacher)) {
            return "{\"result\":\"success\"}";
        } else return "{\"result\":\"failed\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/back/findteacherbyid")
    public Teacher findteacherbyid(int tid) {
        return teacherService.findTeacherBiId(tid);
    }
}
