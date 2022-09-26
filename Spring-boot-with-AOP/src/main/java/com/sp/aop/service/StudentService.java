package com.sp.aop.service;

import com.sp.aop.domain.Student;

import java.util.List;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.aop.service.StrudentService
 *
 * Date    : 26 September 2022
 * Version : 1.0
 **************************************/
public interface StudentService {
    public Student addStudent(Student student);

    public Student getStudent(Long id);

    public Student deleteStudent(Long id);

    public List<Student> viewStudents();

}
