package com.example.assigment1phase1.service;


import com.example.assigment1phase1.model.Course;
import com.example.assigment1phase1.model.Student;

import java.util.*;

public interface StudentService {

    void save(Student s);
    void delete(int id);
    List<Student> getAll();
    Student getById(int id);
    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id);

}
