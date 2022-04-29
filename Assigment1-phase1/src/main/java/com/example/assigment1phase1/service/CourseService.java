package com.example.assigment1phase1.service;

import com.example.assigment1phase1.model.Course;
import java.util.*;

public interface CourseService {

    void save(Course c);
    void delete(int id);
    List<Course> getAll();
    Course getById(int id);

}
