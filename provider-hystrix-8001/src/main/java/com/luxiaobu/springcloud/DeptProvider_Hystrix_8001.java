package com.luxiaobu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableCircuitBreaker// 熔断的支持
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class DeptProvider_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001.class, args);
    }

    // 增加一个Servlet,配合我们的监控使用
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }
}