package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//idea需要先安装Lombok插件
@Data                   //所有属性的get和set方法、toString 方法、hashCode方法、equals方法
@NoArgsConstructor      //无参构造
@Accessors              //链式编程
public class Dept implements Serializable {
    private Long deptNo;
    private String deptName;
    private String deptSource;

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptSource() {
        return deptSource;
    }

    public void setDeptSource(String deptSource) {
        this.deptSource = deptSource;
    }
}
