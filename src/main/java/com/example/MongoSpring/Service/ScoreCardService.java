package com.example.MongoSpring.Service;
import com.example.MongoSpring.Model.*;
import com.example.MongoSpring.Repository.ScoreCardRepo;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ScoreCardService {
    private final ScoreCardRepo repository;

    public ScoreCardService(ScoreCardRepo repository) {
        this.repository = repository;
    }

    public ScoreCard postscore( ScoreCard request) {

        return repository.save(request);
    }
}




