package com.neu.service.impl;

import com.neu.beans.Address;
import com.neu.mapper.BackBranchMapper;
import com.neu.service.BackBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BackBranchServiceImpl implements BackBranchService {
    @Autowired
    BackBranchMapper backBranchMapper;
    @Override
    public List<Address> findBranches(int qid) {
        try {
            return backBranchMapper.findBranches(qid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Address findBranch(int id) {
        try {
            return backBranchMapper.findBranchById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteBranch(int id) {
        try {
            return backBranchMapper.deleteBranch(id)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBranch(Address address) {
        try {
            return backBranchMapper.addBranch(address)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editBranch(Address address) {
        try {
            return backBranchMapper.editBranch(address)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
