package com.luxiaobu.springcloud.service;

import com.luxiaobu.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LUXiAOBU
 * @create 2023/9/21 10:38
 * 服务降级
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long deptNo) {
                return new Dept()
                        .setDeptNo(deptNo)
                        .setDName("服务已降级")
                        .setDbSource("No Database");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
