package com.springcloud.service.impl;

import com.springcloud.dao.DeptDao;
import com.springcloud.pojo.Dept;
import com.springcloud.service.IDeptSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptSVImpl implements IDeptSV {
    @Autowired
    private DeptDao deptDao;

    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public int delDept(Long deptNo) {
        return deptDao.delDept(deptNo);
    }

    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    public List<Dept> selectAllDept() {
        return deptDao.selectAllDept();
    }

    public Dept selectInfoByPrimaryKey(Long deptNo) {
        return deptDao.selectInfoByPrimaryKey(deptNo);
    }
}
