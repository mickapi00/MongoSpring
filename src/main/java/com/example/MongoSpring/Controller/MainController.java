package com.example.MongoSpring.Controller;

// Not Related to database

import java.util.List;

import com.example.MongoSpring.Model.ScoreCard;
import com.example.MongoSpring.Service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Access;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MongoSpring.Model.Course;
import com.example.MongoSpring.Model.CourseLayout;
import com.example.MongoSpring.Model.Marker;
import com.example.MongoSpring.Service.CourseService;
//import com.example.MongoSpring.Service.ScoreCardService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("apitest")


public class MainController {
    @Autowired


    private ScoreCardService scoreCardService;

    @PostMapping("/posting")
    @ResponseBody
    public ResponseEntity<ScoreCard> posting(
            @RequestBody ScoreCard request) {
        // Implement logic here
        ScoreCard created = scoreCardService.postscore(request);
        return ResponseEntity.ok(created);
    }


    // Retrieve markers by course layout ID

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    // CourseLayoutController

    @GetMapping("/coursesLayout/{courseId}")
    public ResponseEntity<List<CourseLayout>> getLayoutsByCourseId(@PathVariable String courseId) {
        List<CourseLayout> layouts = courseService.getLayoutsByCourseId(courseId);
        if (layouts == null || layouts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(layouts);
    }

    @GetMapping("/markers/courseLayoutId/{courseLayoutId}")
    public ResponseEntity<List<Marker>> getMarkersByCourseLayoutId(@PathVariable String courseLayoutId) {
        List<Marker> markers = courseService.getMarkerByCourseLayoutId(courseLayoutId);
        if (markers == null || markers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(markers);
    }
    @GetMapping("/markers/pair")
    public ResponseEntity<List<Marker>> getMarkersByPair(
            @RequestParam(required = false) String markerFront,
            @RequestParam(required = false) String markerBack
    ) {
        List<Marker> markers = courseService.getMarkersByPair(markerFront, markerBack);
        return ResponseEntity.ok(markers);
    }

}

