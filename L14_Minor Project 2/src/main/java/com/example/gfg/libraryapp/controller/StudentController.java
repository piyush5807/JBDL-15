package com.example.gfg.libraryapp.controller;

import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import com.example.gfg.libraryapp.requests.StudentUpdateRequest;
import com.example.gfg.libraryapp.security.User;
import com.example.gfg.libraryapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/student")
    @Secured("role_std")
    public Student getStudent(){

        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();

        return studentService.getStudent(user.getStudent().getId());
    }

    @GetMapping("/student/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student/age/{age}")
    public List<Student> getStudentsByAgeNative(@PathVariable("age") int age){
        return studentService.getStudentsForAgeNativeQuery(age);
    }

    @GetMapping("/student/jpql/age/{age}")
    public List<Student> getStudentsByAgeJPQL(@PathVariable("age") int age){
        return studentService.getStudentsForAgeJPQL(age);
    }

    // sign up --> create user account
    @PostMapping("/student/create")
    public void createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest);
    }

    @PutMapping("/student")
    public void updateStudent(@RequestBody StudentUpdateRequest studentUpdateRequest){

        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();

        studentService.updateStudent(user.getStudent().getId(), studentUpdateRequest);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") int id){
        studentService.deleteStudent(id);
    }

}
