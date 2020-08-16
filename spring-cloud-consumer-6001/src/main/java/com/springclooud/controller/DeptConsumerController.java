package com.springclooud.controller;

import com.springcloud.pojo.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/consumer/dept")
@ResponseBody
public class DeptConsumerController {
    Logger logger = LoggerFactory.getLogger(DeptConsumerController.class);


//    public static final String REQUEST_URL_PRE = "http://127.0.0.1:8001";   //没有配置Ribbon的
    public static final String REQUEST_URL_PRE = "http://SPRING-CLOUD-PROVIDER-DEPT";   //配置Ribbon的，通过服务名访问

    //RestTemplate  发送Http请求，供我们直接调用
    @Autowired
    private RestTemplate restTemplate;

    //增
    @RequestMapping(value = "/addDept")
    public String addDept(Dept dept) {
        Integer result = restTemplate.postForObject(REQUEST_URL_PRE + "/provider/dept/addDept", dept, int.class);
        if (result > 0) {
            return "新增成功";
        } else {
            return "新增失败";
        }
    }
//
//    //删
//    @RequestMapping(value = "delDept", method = RequestMethod.POST)
//    public int delDept(@RequestParam("deptNo") Long deptNo) {
//        return deptSV.delDept(deptNo);
//    }
//
//    //改
//    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
//    public int updateDept(Dept dept) {
//        return deptSV.updateDept(dept);
//    }

    //全查
    @RequestMapping("/selectAllDept")
    public List<Dept> selectAllDept() {
        return restTemplate.getForObject(REQUEST_URL_PRE + "/provider/dept/selectAllDept", List.class);
    }

    //单个查
    @RequestMapping(value = "/selectInfoByPrimaryKey")
    public Dept selectInfoByPrimaryKey(@RequestParam("deptNo") Long deptNo) {
        return restTemplate.getForObject(REQUEST_URL_PRE + "/provider/dept/selectInfoByPrimaryKey?deptNo=" + deptNo, Dept.class);
    }
}
