package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	private static final String REST_PREF_URL = "http://MICROSERVICECLOUD-DEPT";
    /**
     * restTemplate 模板发送请求，http协议
     */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_PREF_URL+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id")Long id){
		return restTemplate.getForObject(REST_PREF_URL+"/dept/get/"+ id, Dept.class);
	}
	
	@RequestMapping("consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_PREF_URL+"/dept/list", List.class);
	}
	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping("/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_PREF_URL+"/dept/discovery", Object.class);
	}
}
