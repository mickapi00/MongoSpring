package com.example.MongoSpring.Service;

import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImplementation
{

    private CourseRepo courseRepository;

    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }
}

