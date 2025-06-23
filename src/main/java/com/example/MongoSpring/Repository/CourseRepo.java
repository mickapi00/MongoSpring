package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseRepo extends MongoRepository<Course, String>

{
    Optional<Course> findByCourseId(String courseId); // Query to find a course by its I
}



