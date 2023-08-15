package com.luxiaobu.springcloud.controller;

import com.luxiaobu.springcloud.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001/";
    private static final String REST_URL_PREFIX = "http://PROVIDER-DEPT";

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        System.out.println(dept.toString());
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, Dept.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
