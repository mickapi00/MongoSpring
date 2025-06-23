package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.ScoreCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReserveRepo extends MongoRepository<ScoreCard, String>
{

    List<ScoreCard> findByUserId(String userId); // Query to find ScoreCards by userId
    List<ScoreCard> findByCourseId(String courseId); // Query to find ScoreCards by courseId
    List<ScoreCard> findByTeeOffDateBetween(LocalDate startDate, LocalDate endDate); // Query to find ScoreCards by date range

}
