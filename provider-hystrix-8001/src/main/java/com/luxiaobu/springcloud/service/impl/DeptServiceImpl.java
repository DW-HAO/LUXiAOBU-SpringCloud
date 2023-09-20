package com.luxiaobu.springcloud.service.impl;

import com.luxiaobu.springcloud.dao.DeptDao;
import com.luxiaobu.springcloud.pojo.Dept;
import com.luxiaobu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long deptNo) {
        return deptDao.queryById(deptNo);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
