package com.example.assigment1phase1.repository;

import com.example.assigment1phase1.model.Course;
import com.example.assigment1phase1.model.Student;
import com.example.assigment1phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class StudentRepo {
    private static List<Student> students;

    private final   CourseService courseService;

    public StudentRepo(CourseService courseService) {
        this.courseService=courseService;
        students =  new ArrayList<>();
        var s = new Student();
        s.setId(1);
        s.setFirstName("Gregory");
        s.setLastName("Ndukwu");
        s.setEmail("ndukwusud@gmail.com");
        s.setMajor("Compro");

        s.setCoursesTaken(courseService.getAll());
        students.add(s);
    }

    public void save(Student s) {
        var checkIfExists = students
                .stream()
                .noneMatch(l -> l.getId()==s.getId());
        if(checkIfExists) {
            students.add(s);
        }
    }

    public void delete(int id) {
        students.stream()
                .filter( l-> l.getId() == id)
                .forEach( l ->students.remove(l));
    }

    public Student getById(int id) {
        return students.stream()
                .filter( l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Student> getAll() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter( s -> s.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.stream()
                .filter( s -> s.getId() == id)
                .findFirst().orElse(null).getCoursesTaken();

    }
}