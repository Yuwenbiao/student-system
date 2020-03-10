package com.example.demo.service;

import com.example.demo.entity.CountAll;
import com.example.demo.entity.Student;

import java.util.List;

/**
 * 学生信息管理
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/3/10 10:10
 */
public interface StudentService {
    /**
     * 添加学生
     *
     * @param student 学生信息
     */
    int addStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    void updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param number 学号
     */
    void deleteStudent(Integer number);

    /**
     * 获取学生
     *
     * @param number  学号
     * @param name    姓名
     * @param classId 班级ID
     * @return 查询结果
     */
    List<Student> getStudent(Integer number, String name, Integer classId);

    /**
     * 统计学生
     *
     * @return 统计结果
     */
    List<CountAll> countStudent(Student student);

    /**
     * 将学生信息导出excel
     */
    void exportStudentsToExcel();
}
