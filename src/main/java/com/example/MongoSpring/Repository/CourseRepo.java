package com.example.MongoSpring.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoSpring.Model.Course;

public interface CourseRepo extends MongoRepository<Course, String>

{
    Optional<Course> findByCourseId(String courseId); // Query to find a course by its I

    Optional<Course> findByname(String name); // Query to find courses by their name

   
}




