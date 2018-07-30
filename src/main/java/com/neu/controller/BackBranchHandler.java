package com.neu.controller;

import com.neu.beans.Address;
import com.neu.beans.User;
import com.neu.service.BackBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BackBranchHandler {
    @Autowired
    BackBranchService backBranchService;
    @ResponseBody
    @RequestMapping(value = "/back/findbranches")
    public Return findBranches(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = ((User) session.getAttribute("user")).getQid();
        List<Address> addresses = backBranchService.findBranches(qid);
        return new Return(0, "", addresses.size(), addresses);
    }

    @ResponseBody
    @RequestMapping(value = "/back/findbranches1")
    public List<Address> findBranches1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = ((User) session.getAttribute("user")).getQid();
        return backBranchService.findBranches(qid);
    }
    @RequestMapping(value = "/back/addbranch")
    @ResponseBody
    public String addBranch(HttpServletRequest request,Address address){
        HttpSession session= request.getSession();
        User user= (User) session.getAttribute("user");
        address.setQid(user.getQid());
        address.setStatus("正在营业");
        if (backBranchService.addBranch(address)){
            return "{\"result\":\"success\"}";
        }else return "{\"result\":\"failed\"}";
    }
    @RequestMapping(value = "/back/editbranch")
    @ResponseBody
    public String editBranch(Address address){
        if (backBranchService.editBranch(address)){
            return "{\"result\":\"success\"}";
        }else return "{\"result\":\"failed\"}";
    }
    @ResponseBody
    @RequestMapping(value = "/back/findbranchbyid")
    public Address findBranchesByid(int id) {
        return backBranchService.findBranch(id);
    }
    @RequestMapping(value = "/back/deletebranch")
    @ResponseBody
    public String deleteBranch(int id){
        if (backBranchService.deleteBranch(id)){
            return "{\"result\":\"success\"}";
        }else return "{\"result\":\"failed\"}";
    }
    class Return {
        private int code;
        private String msg;
        private int count;
        private List<Address> data;

        public Return(int code, String msg, int count, List<Address> data) {
            this.code = code;
            this.msg = msg;
            this.count = count;
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Address> getData() {
            return data;
        }

        public void setData(List<Address> data) {
            this.data = data;
        }
    }
}
