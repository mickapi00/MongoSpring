package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.ScoreCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScoreCardRepo extends MongoRepository<ScoreCard, String>
{


}
