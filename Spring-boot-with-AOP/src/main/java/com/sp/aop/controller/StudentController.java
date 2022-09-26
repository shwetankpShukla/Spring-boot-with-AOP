package com.sp.aop.controller;

import com.sp.aop.domain.Student;
import com.sp.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.aop.controller.StudentController
 *
 * Date    : 26 September 2022
 * Version : 1.0
 **************************************/
@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping(value = "/", produces = "application/json")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping(value = "/{id}",produces = "application/json" )
    public Student getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }

    @DeleteMapping(value = "/{id}",produces =  "application/json")
    public Student deleteStudent(@PathVariable Long id){
        return service.deleteStudent(id);
    }
}
