package com.springcloud.service;

import com.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Integer addDept(Dept dept) {
                return -1;
            }

            @Override
            public List<Dept> selectAllDept() {
                Dept dept = new Dept();
                dept.setDeptNo(-1L);
                dept.setDeptName("用户不存在，无法找到信息,客户端提供降级服务。Hystrix");
                dept.setDeptSource("no data source in mySql!");
                List<Dept> list = Arrays.asList(dept);
                return list;
            }

            @Override
            public Dept selectInfoByPrimaryKey(Long deptNo) {
                Dept dept = new Dept();
                dept.setDeptNo(deptNo);
                dept.setDeptName("用户不存在，无法找到信息,客户端提供降级服务。Hystrix");
                dept.setDeptSource("no data source in mySql!");
                return dept;
            }
        };
    }
}
