package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.pojo.Dept;
import com.springcloud.service.IDeptSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/dept")
public class DeptController {
    Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private IDeptSV deptSV;

    //获取配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    //全查
    @RequestMapping(value = "/selectAllDept")
    public List<Dept> selectAllDept() {
        return deptSV.selectAllDept();
    }

    //单个查
    @RequestMapping(value = "/selectInfoByPrimaryKey")
    @HystrixCommand(fallbackMethod="selectInfoByPrimaryKeyHystrix")
    public Dept selectInfoByPrimaryKey(@RequestParam("deptNo") Long deptNo) {
        Dept dept = deptSV.selectInfoByPrimaryKey(deptNo);
        if(dept == null){
            throw new RuntimeException("deptNo:" + deptNo + "用户不存在，无法找到信息");
        }
        return dept;
    }

    //备选方法
    public Dept selectInfoByPrimaryKeyHystrix(@RequestParam("deptNo") Long deptNo) {
        Dept dept = new Dept();
        dept.setDeptNo(deptNo);
        dept.setDeptName("用户不存在，无法找到信息,Hystrix");
        dept.setDeptSource("no data source in mySql!");
        return dept;
    }


}
