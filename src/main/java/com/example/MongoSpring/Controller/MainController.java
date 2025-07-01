package com.example.MongoSpring.Controller;

// Not Related to database

import com.example.MongoSpring.Model.*;
import com.example.MongoSpring.Service.CourseService;
import com.example.MongoSpring.Service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("apitest")


public class MainController {
    @Autowired
    private ScoreCardService scoreCardService;
    // Access to ScoreCardService

    @PostMapping("/create")
    public ResponseEntity<ScoreCard> CreateScoreCardRequest(
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

    // จาก Server ไปยัง Cilent
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<?> getCourseWithLayout(@PathVariable String courseId) {
        var result = courseService.getCourseWithCourseLayoutId(courseId);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found: " + courseId);
        }
        return ResponseEntity.ok(result);
    }

// CouresLayoutController

    @GetMapping("/courselayoutId/courses/{courseId}")
    public ResponseEntity<List<CourseLayout>> getLayoutsByCourseId(@PathVariable String courseId) {
        List<CourseLayout> layouts = courseService.getLayoutsByCourseId(courseId);
        if (layouts == null || layouts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(layouts);
    }

    @GetMapping("/markers/layouts/{courseLayoutId}")
    public ResponseEntity<List<Marker>> getMarkersByCourseLayoutId(@PathVariable String courseLayoutId) {
        List<Marker> markers = courseService.getMarkerByCourseLayoutId(courseLayoutId);
        if (markers == null || markers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(markers);
    }

    // MarkerDetailsController





//    @PostMapping("/create/{courseId}/{courseName}/{reserveNo}")
//    public ResponseEntity<ScoreCard> createScoreCard(
//            @PathVariable String courseId,
//            @PathVariable String courseName,
//            @PathVariable String reserveNo,
//            @RequestParam String userId) {
//        CreateScoreCardRequest request = new CreateScoreCardRequest();
//        request.setCourseId(courseId);
//        request.setCourseName(courseName);
//        request.setReserveNo(reserveNo);
//        request.setUserId(userId);
//
//        ScoreCard scoreCard = scoreCardService.createScoreCard(request);
//        return ResponseEntity.ok(scoreCard);
//    }

//    @GetMapping("/markersdetails/{markers}/{markersId}/{holeNo}")
//    public ResponseEntity<ScoreCard> mapToBlankScoreCard(
//            @PathVariable String markersId,
//            @PathVariable Integer holeNo) {
//        List<MarkerDetails> markerDetails = courseService.getMarkerDetailsByHole(markersId, holeNo);
//
//        if (markerDetails == null || markerDetails.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        // Create a blank ScoreCard and map data
//        ScoreCard blankScoreCard = new ScoreCard();
//        blankScoreCard.setScore(List.of()); // Initialize empty scores
//        blankScoreCard.setTotalScore(0);
//        blankScoreCard.setTotalIn(0);
//        blankScoreCard.setTotalOut(0);
//        blankScoreCard.setMarkersDetails(markerDetails); // Assuming ScoreCard has a field for MarkerDetails
//
//        return ResponseEntity.ok(blankScoreCard);
//    }
//    // Post Mapping for creating info
//    @PostMapping("/markers/layouts/{courseLayoutId}")
//    public ResponseEntity<Marker> addMarkerToLayout(
//            @PathVariable String courseLayoutId,
//            @RequestBody Marker marker) {
//        Marker saved = courseService.addMarkerToLayout(courseLayoutId, marker);
//        return ResponseEntity.ok(saved);
//    }
}