package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
    Logger logger = LoggerFactory.getLogger(DeptConsumerController.class);

    @Autowired
    private DeptClientService service;

    //增
    @RequestMapping(value = "/addDept")
    public String addDept(Dept dept) {
        Integer result = this.service.addDept(dept);
        if (result > 0) {
            return "新增成功";
        } else {
            return "新增失败";
        }
    }

    //全查
    @GetMapping("/selectAllDept")
    public List<Dept> selectAllDept() {
        return this.service.selectAllDept();
    }

    //单个查
    @GetMapping(value = "/selectInfoByPrimaryKey")
    public Dept selectInfoByPrimaryKey(@RequestParam("deptNo") Long deptNo) {
        return this.service.selectInfoByPrimaryKey(deptNo);
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
