package com.neu.service.impl;

import com.neu.beans.FreeListen;
import com.neu.mapper.BackTrialMapper;
import com.neu.service.BackTrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BackTrialServiceImpl implements BackTrialService {
    @Autowired
    BackTrialMapper trialMapper;

    @Override
    public List<FreeListen> findtrial(int qid, int pageStart, int pageNumber) {
        try {
            return trialMapper.findTrial(qid, pageStart, pageNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public FreeListen fintrialbyid(int id) {
        try {
            return trialMapper.findTrialById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteTrial(int id) {
        try {
            return trialMapper.deleteTrial(id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addTrial(FreeListen freeListen) {
        try {
            return trialMapper.addTrial(freeListen) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editTrial(FreeListen freeListen) {
        try {
            return trialMapper.editTrial(freeListen) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public int getPageNumber(int qid) throws Exception {
		// TODO Auto-generated method stub
		return trialMapper.getPageNumber(qid);
	}
}
