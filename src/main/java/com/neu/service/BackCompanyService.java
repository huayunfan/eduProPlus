package com.neu.service;

import com.neu.beans.Enterprise;
import com.neu.beans.Swiper;

import java.util.List;

public interface BackCompanyService {
    public Enterprise findCompanyByQid(int qid);
    public boolean editCompany(Enterprise enterprise);

    public List<Swiper> findSwiper(int qid);

    public boolean updateSwiper(List<Swiper> swipers);
}
