package com.luxiaobu.springcloud.service;

import com.luxiaobu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component(value = "service")
//@FeignClient(value = "PROVIDER-DEPT")
public interface DeptFeignService {

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/get/{deptNo}")
    Dept queryById(@PathVariable("deptNo") Long deptNo);

    @GetMapping("/dept/list")
    List<Dept> queryAll();
}
