package com.example.demo.entity;

import lombok.Data;

/**
 * 统计各班级人数
 *
 * @author ywb
 * @date 2020/3/10 11:09
 */
@Data
public class CountAll {
    /**
     * 班级名
     */
    private String className;
    /**
     * 人数
     */
    private Integer countNum;
}
