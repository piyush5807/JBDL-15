package com.example.gfg.libraryapp.services;

import com.example.gfg.libraryapp.models.Student;
import com.example.gfg.libraryapp.repository.StudentRepository;
import com.example.gfg.libraryapp.requests.StudentCreateRequest;
import com.example.gfg.libraryapp.requests.StudentUpdateRequest;
import com.example.gfg.libraryapp.security.SecurityCustomConfig;
import com.example.gfg.libraryapp.security.User;
import com.example.gfg.libraryapp.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Value("${student.authority}")
    private String studentAuthority;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Student getStudent(int student_id){
    return studentRepository.findById(student_id).orElse(Student.builder().build());
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(StudentCreateRequest studentCreateRequest){


        User user = User.builder()
                .password(passwordEncoder.encode(studentCreateRequest.getPassword()))
                .username(studentCreateRequest.getUsername())
                .authorities(studentAuthority)
                .build();

        user = userRepository.save(user);

        Student student = Student.builder()
                .name(studentCreateRequest.getName())
                .age(studentCreateRequest.getAge())
                .email(studentCreateRequest.getEmail())
                .user(user)
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
