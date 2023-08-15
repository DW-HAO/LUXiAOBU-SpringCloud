package com.luxiaobu.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
// 链式写法
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptNo;
    private String dName;
    private String dbSource;

    public Dept(String dName) {
        this.dName = dName;
    }

}
