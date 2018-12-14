package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //启动后将此服务注册进eureka注册中心
//@EnableDiscoveryClient //服务发现
public class DeptProvider8001_App {
	//主启动类
    public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
