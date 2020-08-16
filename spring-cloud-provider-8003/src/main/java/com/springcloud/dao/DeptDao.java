package com.springcloud.dao;

import com.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    //增
    public int addDept(Dept dept);

    //删
    public int delDept(@Param("deptNo") Long deptNo);

    //改
    public int updateDept(Dept dept);

    //全查
    public List<Dept> selectAllDept();

    //单个查
    public Dept selectInfoByPrimaryKey(@Param("deptNo") Long deptNo);
}
