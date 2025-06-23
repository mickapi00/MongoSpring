package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.ScoreCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScoreCardRepo extends MongoRepository<ScoreCard, String>
{

    List<ScoreCard> findByUserId(String userId); // Query
    List<ScoreCard> findByCourseId(String courseId);
    List<ScoreCard> findByCourseIdAndUserId(String courseId, String userId); // Query to find ScoreCards by courseId and userId
}
