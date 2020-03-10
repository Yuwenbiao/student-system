package com.example.demo.entity;

import lombok.Data;

/**
 * 学生信息
 *
 * @author ywb
 * @date 2020/3/10 10:03
 */
@Data
public class Student {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学号
     */
    private Integer number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 班级Id
     */
    private Integer classId;
    /**
     * 生日
     */
    private String birthDay;
}
