package com.neu.mapper;

import com.neu.beans.Enterprise;
import com.neu.beans.Swiper;

import java.sql.SQLException;
import java.util.List;

public interface BackCompanyMapper {
    public Enterprise findCompanyByQid(int qid) throws SQLException;
    public int editCompany(Enterprise enterprise) throws SQLException;

    public List<Swiper> findSwiper(int qid) throws SQLException;

    public int updateSwiper(Swiper swiper) throws SQLException;
}
