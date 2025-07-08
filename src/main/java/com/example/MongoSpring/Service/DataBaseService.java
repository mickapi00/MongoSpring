package com.example.MongoSpring.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Model.CourseLayout;
import com.example.MongoSpring.Model.Marker;
import com.example.MongoSpring.Model.UpdateMarker;
import com.example.MongoSpring.Repository.CourseLayoutRepo;
import com.example.MongoSpring.Repository.CourseRepo;
import com.example.MongoSpring.Repository.MarkerRepo;

import lombok.Data;

@Data
@Service

public class DataBaseService
{

    private final MarkerRepo markerRepository;
    private final CourseRepo courseRepository;
    private final CourseLayoutRepo courseLayoutRepository;

    public DataBaseService(MarkerRepo markerRepository,
                           CourseRepo courseRepository,
                           CourseLayoutRepo courseLayoutRepository)
    {
        this.markerRepository = markerRepository;
        this.courseRepository = courseRepository;
        this.courseLayoutRepository = courseLayoutRepository;
    }

    // Marker CRUD 

    public Marker createMarker(Marker marker) {
        return markerRepository.save(marker);
    }
    public Marker updateMarker(String id, UpdateMarker updatesMarker)
    {
        Marker  updatedMarker = markerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Marker not found with ID: " + id));

        // Update fields from DTO
        updatedMarker.setMarkersId(updatesMarker.getMarkersId());
        updatedMarker.setCourseName(updatesMarker.getCourseName());
        updatedMarker.setCourseLayoutId(updatesMarker.getCourseLayoutId());

        return markerRepository.save(updatedMarker);
    }


    public Marker getMarkerBymarkersId(String markersId) {
        List<Marker> markers = markerRepository.findByMarkersId(markersId);
        if (markers.isEmpty()) {
            throw new NoSuchElementException("Marker not found");
        }
        return markers.get(0);
    }

    public void deleteMarker(String id) {
        markerRepository.deleteById(id);
    }

    // Course CRUD
    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }


     public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(String id, Course UpdatedCourse) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(UpdatedCourse.getName());
            course.setCourseId(UpdatedCourse.getCourseId());
            course.set_id(UpdatedCourse.get_id());
            courseRepository.save(course);
        }
        return course;

        
    }

    public void deleteCourse(String id) {
    courseRepository.deleteById(id);
    }


    // Course Layout CRUD
   
    public List<CourseLayout> getLayoutsByCourseId(String courseId) {
        return courseLayoutRepository.findByCourseId(courseId);
    }

    
    public CourseLayout createCourseLayout(CourseLayout courseLayout) {
        return courseLayoutRepository.save(courseLayout);
    }

    public CourseLayout updateCourseLayout(String id, CourseLayout updatedLayout) {
        CourseLayout layout = courseLayoutRepository.findById(id).orElse(null);
        if (layout != null) {
            layout.set_id(updatedLayout.get_id());
            layout.setCourseId(updatedLayout.getCourseId());
            layout.setCourseName(updatedLayout.getCourseName());
            layout.setCourselayoutId(updatedLayout.getCourselayoutId());
            layout.setTotalPar(updatedLayout.getTotalPar());
            courseLayoutRepository.save(layout);
        }
        return layout;
    }

    public CourseLayout getCourseLayoutById(String id) {
        return courseLayoutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course Layout not found"));
    }

    public List<CourseLayout> getAllCourseLayouts() {
        return courseLayoutRepository.findAll();
    }

    public boolean deleteCourseLayout(String id) {
        if (courseLayoutRepository.existsById(id)) {
            courseLayoutRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
}
