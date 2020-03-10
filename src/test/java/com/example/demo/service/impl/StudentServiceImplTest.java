package com.example.demo.service.impl;

import com.example.demo.entity.CountAll;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;

    @Test
    void testAddStudent() {
        Student student = new Student();
        student.setNumber(123);
        student.setName("Tom");
        student.setSex(0);
        student.setBirthDay("2010-12-12");
        student.setClassId(1);
        studentService.addStudent(student);
    }

    @Test
    void testDeleteStudent() {
        studentService.deleteStudent(123);
    }

    @Test
    void testGetStudent() {
        List<Student> studentList = studentService.getStudent(123, null, null);
        System.out.println(studentList.size());
    }

    @Test
    void testCountStudent() {
        List<CountAll> countAll = studentService.countStudent(null);
        System.out.println(countAll.toString());
    }

    @Test
    void testCountStudentSex() {
        Student student = new Student();
        student.setSex(0);
        List<CountAll> countAll = studentService.countStudent(student);
        System.out.println(countAll.toString());
    }

    @Test
    void exportStudentsToExcel() {
        studentService.exportStudentsToExcel();
    }

    @Test
    void updateStudent() {
        Student student = new Student();
        student.setNumber(123);
        student.setName("Tom2");
        student.setSex(0);
        student.setBirthDay("2010-12-12");
        student.setClassId(1);
        studentService.updateStudent(student);
    }
}