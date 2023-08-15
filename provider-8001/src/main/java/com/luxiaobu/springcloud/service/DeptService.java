package com.luxiaobu.springcloud.service;

import com.luxiaobu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryById(Long deptNo);

    List<Dept> queryAll();
}
