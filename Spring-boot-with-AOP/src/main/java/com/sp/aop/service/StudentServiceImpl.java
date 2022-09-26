package com.sp.aop.service;

import com.sp.aop.domain.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.aop.service.StudentServiceImpl
 *
 * Date    : 26 September 2022
 * Version : 1.0
 **************************************/
@Service
public class StudentServiceImpl implements StudentService{

    private Map<Long,Student> map=new HashMap();

    @Override
    public Student addStudent(Student student) {
        map.put(student.getId(), student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return map.get(id);
    }

    @Override
    public Student deleteStudent(Long id) {
        return map.remove(id);
    }

    @Override
    public List<Student> viewStudents() {
        return null;
    }

}
