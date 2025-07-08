package com.example.MongoSpring.Controller;

// Not Related to database

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.MongoSpring.Model.CreateScoreCardRequest;
import com.example.MongoSpring.Model.Marker;
import com.example.MongoSpring.Model.ScoreCard;
import com.example.MongoSpring.Model.ScoreInput;
import com.example.MongoSpring.Model.ScoreSummary;
import com.example.MongoSpring.Model.ScoreUpdateInput;
import com.example.MongoSpring.Service.CourseService;
import com.example.MongoSpring.Service.ScoreCardService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("apitest")


public class MainController {
    @Autowired
    private ScoreCardService scoreCardService;
    // Access to ScoreCardService

    @PostMapping("/create")
    public ResponseEntity<ScoreCard> createScoreCard(
            @RequestBody CreateScoreCardRequest request) {
        // Implement logic here
        ScoreCard created = scoreCardService.createScoreCard(request);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/{id}/scores")
    public ResponseEntity<ScoreCard> addScore(
            @PathVariable String id,
            @RequestBody ScoreInput inputs
    ) {
        // Add score to scorecard
        ScoreCard updated = scoreCardService.addScore(id, inputs);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/scores/{hole}")
    public ResponseEntity<ScoreCard> editScore
            (
                    @PathVariable String id,
                    @PathVariable int hole,
                    @RequestBody ScoreUpdateInput input// ข้อมูลที่ Edit
            ) {
        // Edit score for given hole
        ScoreCard updatedScorecard = scoreCardService.editScore(id, hole, input);
        return ResponseEntity.ok(updatedScorecard);
    }

    @DeleteMapping("/{id}/scores/{hole}")
    public ResponseEntity<ScoreCard> deleteScore(
            @PathVariable String id,
            @PathVariable int hole) {
        // Delete score for given hole
        ScoreCard updatedScorecard = scoreCardService.deleteScore(id, hole);
        return ResponseEntity.ok(updatedScorecard);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScoreCard> getScoreCardById(
            @PathVariable String id) {        // Retrieve scorecard by ID
        ScoreCard scoreCard = scoreCardService.getScoreCardById(id);
        return ResponseEntity.ok(scoreCard);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ScoreCard> getScoreCardByUserId(
            @PathVariable String userId) {
        // Retrieve scorecards by user ID
        return ResponseEntity.ok(scoreCardService.getScoreCardsByUserId(userId));
    }


    // Retrieve markers by course layout ID

    @Autowired
    private CourseService courseService;

    //


    //

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

    @GetMapping("/markers/{courseLayoutId}")
    public ResponseEntity<List<Marker>> getMarkersByCourseLayoutId(@PathVariable String courseLayoutId) {
        List<Marker> markers = courseService.getMarkerByCourseLayoutId(courseLayoutId);
        if (markers == null || markers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(markers);
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<ScoreSummary> getScoreSummary(@PathVariable String id) {
        try {
            ScoreSummary summary = scoreCardService.getScoreSummary(id);
            return ResponseEntity.ok(summary);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}