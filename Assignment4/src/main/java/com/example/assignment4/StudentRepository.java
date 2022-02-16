package com.example.assignment4;

import org.springframework.data.repository.CrudRepository;
import com.example.assignment4.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByStudentID(Integer studentID);
}
