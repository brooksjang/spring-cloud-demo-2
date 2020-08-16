package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors
public class Dept implements Serializable {
    private Long deptNo;
    private String deptName;
    private String deptSource;
}
