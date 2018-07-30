package com.neu.mapper;

import com.neu.beans.Address;

import java.sql.SQLException;
import java.util.List;

public interface BackBranchMapper {
    public List<Address> findBranches(int qid) throws SQLException;
    public Address findBranchById(int id) throws SQLException;
    public int deleteBranch(int id) throws SQLException;
    public int addBranch(Address address)throws SQLException;
    public int editBranch(Address address)throws SQLException;
}
