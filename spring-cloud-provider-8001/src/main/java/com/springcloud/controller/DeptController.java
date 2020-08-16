package com.springcloud.controller;

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

    //增
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public int addDept(@RequestBody Dept dept) {
        return deptSV.addDept(dept);
    }

    //删
    @RequestMapping(value = "/delDept", method = RequestMethod.POST)
    public int delDept(@RequestParam("deptNo") Long deptNo) {
        return deptSV.delDept(deptNo);
    }

    //改
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public int updateDept(Dept dept) {
        return deptSV.updateDept(dept);
    }

    //全查
    @RequestMapping(value = "/selectAllDept")
    public List<Dept> selectAllDept() {
        return deptSV.selectAllDept();
    }

    //单个查
    @RequestMapping(value = "/selectInfoByPrimaryKey")
    public Dept selectInfoByPrimaryKey(@RequestParam("deptNo") Long deptNo) {
        return deptSV.selectInfoByPrimaryKey(deptNo);
    }

    /**
     * 获取注册进来的微服务的一些消息
     */
    @RequestMapping("/discovery")
    public Object getDiscovery() {
        List<String> services = client.getServices();
        //查看所有微服务的信息
        logger.info("Discovery Services：" + services.toString());
        //得到一个具体微服务的信息
        List<ServiceInstance> instances = client.getInstances("SPRING-CLOUD-PROVIDER-DEPT-8001");
        for (ServiceInstance instance : instances) {
            logger.info(instance.getHost());
            logger.info(instance.getInstanceId());
            logger.info(String.valueOf(instance.getUri()));
            logger.info(String.valueOf(instance.getPort()));
        }
        return this.client;
    }
}
