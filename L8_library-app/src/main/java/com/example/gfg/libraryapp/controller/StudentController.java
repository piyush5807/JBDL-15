package com.example.gfg.libraryapp.controller;

import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import com.example.gfg.libraryapp.requests.StudentUpdateRequest;
import com.example.gfg.libraryapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("student_id") int student_id){
        return studentService.getStudent(student_id);
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

    @PostMapping("/student")
    public void createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest);
    }

    @PutMapping("/student")
    public void updateStudent(@RequestParam("id") int id, @RequestBody StudentUpdateRequest studentUpdateRequest){
        studentService.updateStudent(id, studentUpdateRequest);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") int id){
        studentService.deleteStudent(id);
    }

}
