package com.example.MongoSpring.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Model.CourseLayout;
import com.example.MongoSpring.Model.Marker;
import com.example.MongoSpring.Model.UpdateMarker;
import com.example.MongoSpring.Service.DataBaseService;


@RestController
@RequestMapping("/api")
public class DatabaseController {
    @Autowired
    private DataBaseService dataBaseService;

    // Marker Endpoints
    @PostMapping("/markers")
    public ResponseEntity<Marker> createMarker(
            @RequestBody Marker marker) {
        Marker create = dataBaseService.createMarker(marker);
        return ResponseEntity.ok(create);
    }

    @PutMapping("/markers/{id}")
    public ResponseEntity<Marker> updatedMarker(
            @PathVariable String id,
            @RequestBody UpdateMarker input) {
        Marker updatedMarker = dataBaseService.updateMarker(id, input);
        return ResponseEntity.ok(updatedMarker);
    }


    @DeleteMapping("/markers/{id}")
    public ResponseEntity<Void> deleteMarker
            (@PathVariable String id) {
        dataBaseService.deleteMarker(id);
        return ResponseEntity.noContent().build();
    }
    // === Course Endpoints ===


    
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course created = dataBaseService.createCourse(course);
        return ResponseEntity.status(201).body(created);  // 201 CREATED
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        Course updated = dataBaseService.updateCourse(id, course);
        if (updated == null) {
            return ResponseEntity.notFound().build();  // 404 if not found
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Course course = dataBaseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = dataBaseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        dataBaseService.deleteCourse(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }

    // === CourseLayout Endpoints ===
    @PostMapping("/course-layouts")
    public ResponseEntity<CourseLayout> createCourseLayout(@RequestBody CourseLayout courseLayout) {
        CourseLayout created = dataBaseService.createCourseLayout(courseLayout);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/course-layouts/{id}")
    public ResponseEntity<CourseLayout> updateCourseLayout(
            @PathVariable String id,
            @RequestBody CourseLayout courseLayout) {
        CourseLayout updated = dataBaseService.updateCourseLayout(id, courseLayout);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/course-layouts/{id}")
        public ResponseEntity<List<CourseLayout>> getCourseLayoutById(
            @PathVariable String id) {
        List<CourseLayout> layoutList = dataBaseService.getLayoutsByCourseId(id);
    if (layoutList == null || layoutList.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(layoutList);
}


    @GetMapping("/course-layouts")
    public ResponseEntity<List<CourseLayout>> getAllCourseLayouts() {
        List<CourseLayout> layouts = dataBaseService.getAllCourseLayouts();
        return ResponseEntity.ok(layouts);
    }

    @DeleteMapping("/course-layouts/{id}")
    public ResponseEntity<Void> deleteCourseLayout(@PathVariable String id) {
          dataBaseService.deleteCourseLayout(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }
     
}