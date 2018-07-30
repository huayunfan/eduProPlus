package com.neu.service.impl;

import com.neu.beans.Lesson;
import com.neu.beans.LessonBranch;
import com.neu.mapper.BackQualityMapper;
import com.neu.service.BackQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class BackQualityServiceImpl implements BackQualityService {
    @Autowired
    BackQualityMapper qualityMapper;

    @Override
    public List<Lesson> findQuanlity(int qid, int pageStart, int pageNumber) {
        try {
            return qualityMapper.findQuality(qid, pageStart, pageNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteQuanlity(int lid) {
        try {
            return qualityMapper.deleteQuality(lid) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Lesson finQualityById(int lid) {
        try {
            return qualityMapper.finQualityById(lid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addlessonbranch(LessonBranch lessonBranch) {
        try {
            return qualityMapper.addlessonbranch(lessonBranch) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Integer> findBranchIds(int lid) {
        try {
            return qualityMapper.findBranchIds(lid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> findCategory(int qid) {
        try {
            return qualityMapper.findCategory(qid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    @Override
    public boolean deletelessonbranch(int lid) {
        try {
            return qualityMapper.deletelessonbranch(lid) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> findBranchNames(int lid) {
        try {
            return qualityMapper.findBranchNames(lid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addQuality(Lesson lesson, List<Integer> t) {
        try {
            if (qualityMapper.addQuality(lesson) > 0) {
                for (int tt : t) {
                    LessonBranch lessonBranch = new LessonBranch();
                    lessonBranch.setBranchid(tt);
                    lessonBranch.setLid(lesson.getLid());
                    qualityMapper.addlessonbranch(lessonBranch);
                }
                return lesson.getLid();
            } else return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean editQuality(Lesson lesson, List<Integer> t) {
        try {
            if (qualityMapper.editQuality(lesson) > 0) {
                qualityMapper.deletelessonbranch(lesson.getLid());
                for (int tt : t) {
                    LessonBranch lessonBranch = new LessonBranch();
                    lessonBranch.setBranchid(tt);
                    lessonBranch.setLid(lesson.getLid());
                    qualityMapper.addlessonbranch(lessonBranch);
                }
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public int getPageNumber(int qid) throws Exception {
		// TODO Auto-generated method stub
		return qualityMapper.getPageNumber(qid);
	}
}
