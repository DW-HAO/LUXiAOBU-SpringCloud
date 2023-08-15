package com.luxiaobu.springcloud.controller;

import com.luxiaobu.springcloud.pojo.Dept;
import com.luxiaobu.springcloud.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptFeignController {

    @Autowired
    private DeptFeignService service;

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return service.queryById(deptNo);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return service.queryAll();
    }
}
