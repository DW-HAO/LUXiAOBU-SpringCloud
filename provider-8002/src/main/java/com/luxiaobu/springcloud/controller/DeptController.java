package com.luxiaobu.springcloud.controller;

import com.luxiaobu.springcloud.pojo.Dept;
import com.luxiaobu.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        System.out.println(dept.toString());
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{deptNo}")
    public Dept queryById(@PathVariable("deptNo") Long deptNo) {
//        log.info("deptNo=>{}", deptNo);
        return deptService.queryById(deptNo);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
}