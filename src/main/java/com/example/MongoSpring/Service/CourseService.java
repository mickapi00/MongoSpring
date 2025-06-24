package com.example.MongoSpring.Service;

import com.example.MongoSpring.Model.*;

import com.example.MongoSpring.Repository.CourseRepo;
import com.example.MongoSpring.Repository.CourseLayoutRepo;
import com.example.MongoSpring.Repository.MarkerDetailsRepo;
import com.example.MongoSpring.Repository.MarkerRepo;
import org.springframework.stereotype.Service;


import java.util.*;


    @Service
    public class CourseService {

        private final CourseRepo courseRepo;
        private final CourseLayoutRepo courseLayoutRepo;
        private final MarkerRepo markerRepo;
        private final MarkerDetailsRepo markerDetailsRepo;


        public CourseService(CourseRepo courseRepo, CourseLayoutRepo courseLayoutRepo, MarkerRepo markerRepo, MarkerDetailsRepo markerDetailsRepo) {
            this.courseRepo = courseRepo;
            this.courseLayoutRepo = courseLayoutRepo;
            this.markerRepo = markerRepo;
            this.markerDetailsRepo = markerDetailsRepo;
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
            if (!courseOpt.isPresent()) {
                throw new RuntimeException("Course not found");
            }
            Course course = courseOpt.get();

            List<CourseLayout> layouts = courseLayoutRepo.findByCourseId(course.getCourseId());

            Map<String, Object> result = new HashMap<>();
            result.put("course", course);
            result.put("layouts", layouts);
            return result;
        }

        public List<MarkerDetails> getMarkerDetails(String markersId) {
            return markerDetailsRepo.findByMarkersId(markersId);
        }

        public List<MarkerDetails> getMarkerDetailsByHole(String markersId, Integer holeNo) {
            return markerDetailsRepo.findByMarkersIdAndHoleNo(markersId, holeNo);
        }

        public Marker addMarkerToLayout(String courseLayoutId, Marker marker) {
            marker.setCourseLayoutId(courseLayoutId);
            return markerRepo.save(marker);
        }

    }

