package com.example.gfg.libraryapp.repository;

import com.example.gfg.libraryapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Bank SBI -> ICICI - 100

    // 1. JPQL - Java Persistence Query language - queries wrt java class
    // 2. Native SQL Query - queries wrt your database

    // Find all the students whose age > 10

    // JPQL
    @Transactional
    @Query("select s from Student s where s.age > :age_no")
//    @Query("select s from Student s where s.age > ?1 and s.email = ?2")
    List<Student> getStudentsByAgeJPQL(int age_no);

    // Native Query
    @Query(value = "select * from my_student where age > :age", nativeQuery = true)
    List<Student> getStudentsByAgeNative(int age);

    @Transactional
    @Modifying
    @Query("update Student s set s.email = ?1, s.name = ?2,  s.age = ?3 where s.id = ?4")
    void update(String email, String name, int age, int id);
}