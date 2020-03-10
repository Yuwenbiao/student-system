package com.example.demo.mapper;

import com.example.demo.entity.CountAll;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生信息Mapper
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/3/10 10:11
 */
@Mapper
public interface StudentMapper {
    /**
     * 添加学生
     *
     * @param student 学生信息
     */
    void addStudent(Student student);

    /**
     * 删除学生
     *
     * @param id 学号
     */
    void deleteStudent(Integer id);

    /**
     * 获取学生
     *
     * @param student 查询条件
     * @return 查询结果
     */
    List<Student> getStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     */
    void updateStudent(Student student);

    /**
     * 统计学生
     *
     * @param student 查询条件
     */
    CountAll countStudent(Student student);
}
