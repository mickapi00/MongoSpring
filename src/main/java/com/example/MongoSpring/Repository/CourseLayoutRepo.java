package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.CourseLayout;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;



public interface CourseLayoutRepo extends MongoRepository<CourseLayout, String>
{
        List<CourseLayout> findByCourseId(String courseId);
}


