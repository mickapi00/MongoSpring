package com.example.MongoSpring.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Model.CourseLayout;
import com.example.MongoSpring.Model.Marker;
import com.example.MongoSpring.Repository.CourseLayoutRepo;
import com.example.MongoSpring.Repository.CourseRepo;
import com.example.MongoSpring.Repository.MarkerRepo;


    @Service
    public class CourseService {

        private final CourseRepo courseRepo;
        private final CourseLayoutRepo courseLayoutRepo;
        private final MarkerRepo markerRepo;



        public CourseService(CourseRepo courseRepo, CourseLayoutRepo courseLayoutRepo, MarkerRepo markerRepo) {
            this.courseRepo = courseRepo;
            this.courseLayoutRepo = courseLayoutRepo;
            this.markerRepo = markerRepo;
        }


        public List<Course> getAllCourses() {
            return courseRepo.findAll();
        }

        public List<CourseLayout> getAllLayouts(Course course) {
            return courseLayoutRepo.findByCourseId(course.getCourseId());
        }
        // ดึง layout ทั้งหมด

        // ดึง layout ตาม courseId
        public List<CourseLayout> getLayoutsByCourseId(String courseId) {
            return courseLayoutRepo.findByCourseId(courseId);

        }


        public List<Marker> getMarkerByCourseLayoutId(String courseLayoutId) {
            return markerRepo.findByCourseLayoutId(courseLayoutId);
            // ดึง course ตาม courseId

        }

        public Map<String, Object> getCourseWithCourseLayoutId(String courseId) {
        Optional<Course> courseOpt = courseRepo.findByCourseId(courseId);

        if (courseOpt.isEmpty()) {
        throw new NoSuchElementException("Course not found with ID: " + courseId);
        }

        Course course = courseOpt.get();

        List<CourseLayout> layouts = courseLayoutRepo.findByCourseId(course.getCourseId());

        Map<String, Object> result = new HashMap<>();
        result.put("course", course);
        result.put("layouts", layouts);
        return result;
}



        public Marker addMarkerToLayout(String courseLayoutId, Marker marker) {marker.setCourseLayoutId(courseLayoutId);
            return markerRepo.save(marker);

        }}

