package com.example.demo.service.impl;

import com.example.demo.entity.CountAll;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import com.example.demo.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生信息管理
 *
 * @author ywb
 * @date 2020/3/10 10:14
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加学生
     *
     * @param student 学生信息
     */
    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    /**
     * 删除学生
     *
     * @param number 学号
     */
    @Override
    public void deleteStudent(Integer number) {
        studentMapper.deleteStudent(number);
    }

    /**
     * 获取学生
     */
    @Override
    public List<Student> getStudent(Integer number, String name, Integer classId) {
        Student student = new Student();
        student.setName(name);
        student.setNumber(number);
        student.setClassId(classId);
        List<Student> studentList = studentMapper.getStudent(student);
        return studentList;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public CountAll countStudent(Student student) {
        return studentMapper.countStudent(student);
    }

    /**
     * 将学生信息导出excel
     */
    @Override
    public void exportStudentsToExcel() {
        List<Student> studentList = studentMapper.getStudent(null);
        ExcelUtil.writeExcel(studentList, "output.xlsx");
    }
}
