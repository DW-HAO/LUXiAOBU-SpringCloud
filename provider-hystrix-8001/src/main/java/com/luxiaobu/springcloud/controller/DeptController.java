package com.luxiaobu.springcloud.controller;

import com.luxiaobu.springcloud.pojo.Dept;
import com.luxiaobu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{deptNo}")
    @HystrixCommand(fallbackMethod = "fallBackGet")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        Dept dept = deptService.queryById(deptNo);
        if (dept == null) {
            throw new RuntimeException("deptNo->" + deptNo + "不存在");
        }
        return dept;
    }

    public Dept fallBackGet(@PathVariable("deptNo") Long deptNo) {
        Dept dept = new Dept(deptNo, null, null);
        log.warn("No Object Dept!");
        return dept;
    }
}