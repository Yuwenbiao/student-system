package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.CountAll;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生信息管理
 *
 * @author ywb
 * @date 2020/3/10 10:22
 */
@RestController
@RequestMapping("student")
public class StudentController {
    private static final String SUCCESS = "success";

    @Autowired
    StudentService studentService;

    /**
     * 添加学生
     *
     * @return 添加结果
     */
    @RequestMapping("add")
    public JSONObject addStudent(Student student) {
        JSONObject result = new JSONObject();
        studentService.addStudent(student);

        result.put("code", SUCCESS);
        return result;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生
     * @return 修改结果
     */
    @RequestMapping("edit")
    public JSONObject editStudent(Student student) {
        JSONObject result = new JSONObject();
        studentService.updateStudent(student);

        result.put("code", SUCCESS);
        return result;
    }

    /**
     * 删除学生
     *
     * @param number 学号
     * @return 删除结果
     */
    @RequestMapping("delete")
    public JSONObject deleteStudent(Integer number) {
        JSONObject result = new JSONObject();
        studentService.deleteStudent(number);

        result.put("code", SUCCESS);
        return result;
    }

    /**
     * 根据学号、姓名、班级查询学生
     *
     * @param number  学号
     * @param name    姓名
     * @param classId 班级ID
     * @return 查询结果
     */
    @RequestMapping("query")
    public JSONObject queryStudent(Integer number, String name, Integer classId) {
        JSONObject result = new JSONObject();
        List<Student> studentList = studentService.getStudent(number, name, classId);

        result.put("code", SUCCESS);
        result.put("studentList", studentList);
        return result;
    }

    /**
     * 统计班级人数
     *
     * @return 班级人数
     */
    @RequestMapping("count_all")
    public JSONObject countAllStudent() {
        JSONObject result = new JSONObject();
        List<CountAll> countAllList = studentService.countStudent(null);

        result.put("code", SUCCESS);
        result.put("countAll", countAllList);
        return result;
    }

    /**
     * 根据性别统计班级人数
     *
     * @param sex 性别
     * @return 班级人数
     */
    @RequestMapping("count_sex")
    public JSONObject countStudentSex(Integer sex) {
        JSONObject result = new JSONObject();
        Student student = new Student();
        student.setSex(sex);

        List<CountAll> countAll = studentService.countStudent(student);
        result.put("code", SUCCESS);
        result.put("countAll", countAll);
        return result;
    }

    /**
     * 导出数据到Excel中
     */
    @RequestMapping("export")
    public JSONObject exportStudent() {
        JSONObject result = new JSONObject();
        studentService.exportStudentsToExcel();
        result.put("code", SUCCESS);
        return result;
    }
}
