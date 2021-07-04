package com.example.gfg.libraryapp.services;

import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.repository.StudentRepository;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import com.example.gfg.libraryapp.requests.StudentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int student_id){
    return studentRepository.findById(student_id).orElse(Student.builder().build());
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(StudentCreateRequest studentCreateRequest){

        Student student = Student.builder()
            .name(studentCreateRequest.getName())
            .age(studentCreateRequest.getAge())
            .email(studentCreateRequest.getEmail())
            .build();

        studentRepository.save(student);

    }

//    public Student updateStudent(int id, StudentUpdateRequest studentUpdateRequest){
//
//        Student student = studentRepository.getById(id);
//        if(studentUpdateRequest.getAge() != 0){
//            student.setAge(studentUpdateRequest.getAge());
//        }
//
//        if(studentUpdateRequest.getName() != null){
//            student.setName(studentUpdateRequest.getName());
//        }
//
//        if(studentUpdateRequest.getEmail() != null){
//            student.setEmail(studentUpdateRequest.getEmail());
//        }
//
//        return studentRepository.save(student);
//    }

    public void updateStudent(int id, StudentUpdateRequest studentUpdateRequest){
        studentRepository.update(studentUpdateRequest.getEmail(),
                studentUpdateRequest.getName(),
                studentUpdateRequest.getAge(),
                id);
    }

    public void deleteStudent(int student_id){
        studentRepository.deleteById(student_id);
    }

    public List<Student> getStudentsForAgeJPQL(int age){
        return studentRepository.getStudentsByAgeJPQL(age);
    }

    public List<Student> getStudentsForAgeNativeQuery(int age){
        return studentRepository.getStudentsByAgeNative(age);
    }
}
