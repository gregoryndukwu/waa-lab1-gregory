package com.example.assigment1phase1.service.impl;

import com.example.assigment1phase1.model.Course;
import com.example.assigment1phase1.repository.CourseRepo;
import com.example.assigment1phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public void save(Course c) {
        courseRepo.save(c);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }


}