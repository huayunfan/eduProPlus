package com.neu.service;

import com.neu.beans.Address;

import java.util.List;

public interface BackBranchService {
    public List<Address> findBranches(int qid);
    public Address findBranch(int id);
    public boolean deleteBranch(int id);
    public boolean addBranch(Address address);
    public boolean editBranch(Address address);
}
