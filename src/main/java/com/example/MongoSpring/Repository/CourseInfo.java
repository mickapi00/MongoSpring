package com.example.MongoSpring.Repository;


import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Model.CourseLayout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CourseInfo extends MongoRepository<CourseInfo,String>
{
}
