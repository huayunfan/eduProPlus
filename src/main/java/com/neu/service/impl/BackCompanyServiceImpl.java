package com.neu.service.impl;

import com.neu.beans.Enterprise;
import com.neu.beans.Swiper;
import com.neu.mapper.BackCompanyMapper;
import com.neu.service.BackCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BackCompanyServiceImpl implements BackCompanyService {
    @Autowired
    BackCompanyMapper companyMapper;

    @Override
    public Enterprise findCompanyByQid(int qid) {
        try {
            return companyMapper.findCompanyByQid(qid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editCompany(Enterprise enterprise) {
        try {
            return companyMapper.editCompany(enterprise) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Swiper> findSwiper(int qid) {
        try {
            return companyMapper.findSwiper(qid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateSwiper(List<Swiper> swipers) {
        try {
            for (Swiper swiper : swipers) {
                companyMapper.updateSwiper(swiper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
