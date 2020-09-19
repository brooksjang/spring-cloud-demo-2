package com.springcloud.service;

import com.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
//服务降级
@FeignClient(value = "SPRING-CLOUD-PROVIDER-DEPT", fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    //增
    @RequestMapping(value = "/provider/dept/addDept")
    public Integer addDept(Dept dept);

    //全查
    @RequestMapping("/provider/dept/selectAllDept")
    public List<Dept> selectAllDept();

    //单个查
    @RequestMapping(value = "/provider/dept/selectInfoByPrimaryKey")
    public Dept selectInfoByPrimaryKey(@RequestParam("deptNo") Long deptNo);
}
