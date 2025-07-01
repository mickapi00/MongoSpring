package com.example.MongoSpring.Service;
import com.example.MongoSpring.Model.ScoreInput;
import com.example.MongoSpring.Model.*;
import com.example.MongoSpring.Repository.ScoreCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScoreCardService
{
    private final ScoreCardRepo repository;

    public ScoreCardService(ScoreCardRepo repository) {
        this.repository = repository;
    }

    public ScoreCard createScoreCard (CreateScoreCardRequest request )
    {
        // Convert CreateScoreCardRequest to ScoreCard
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.setUserId(request.getUserId()); // มันเอามา getUser ID เพราะมี User ID อยู่ใน CreateScoreCardRequest// Assuming a static name for simplicity
        scoreCard.setTeeOffDate(LocalDate.now());
        scoreCard.setCourseId(request.getCourseId());// courseId from request createScoreCardRequest
        scoreCard.setCourseName(request.getCourseName());
        scoreCard.setTotalScore(0);
        scoreCard.setTotalIn(0);
        scoreCard.setTotalOut(0);
        scoreCard.setReserveId(request.getReserveNo());
        scoreCard.setScore(List.of());// empty list for scores
        return repository.save(scoreCard);
    }


    public ScoreCard addScore(String id, ScoreInput score) {
        ScoreCard card = repository.findById(id).orElse(null);// found scorecard not found = null
        if (card != null) {
            // Add score to the scorecard
            Score newScore = new Score();
            newScore.setCourseName("");
            newScore.setHoleNo(score.getHoleNo());
            newScore.setPar(0);
            newScore.setHandicap(0);
            newScore.setScore(score.getScore());

            card.getScore().add(newScore);
            repository.save(card);

        }
        return card;
    }

    public ScoreCard editScore(String id, int hole, ScoreUpdateInput score) {
        ScoreCard card = repository.findById(id).orElse(null);
        if (card != null) {
            card.getScore().removeIf(s -> s.getHoleNo() == hole);
            card.getScore().add(score);
            repository.save(card);
        }
        return card;
    }

    public ScoreCard deleteScore(String id, int hole) {
        ScoreCard card = repository.findById(id).orElse(null);
        if (card != null) {
            card.getScore().removeIf(s -> s.getHoleNo() == hole);
            repository.save(card);
        }
        return card;
    }

    public ScoreCard getScoreCardById(String id) {
        ScoreCard card = repository.findById(id).orElse(null);
        if (card == null)
        {
            return null;
        }
        return repository.findById(id).orElse(null); // ก็อาจจะต้องใช้มั้ง
    }
//

    public ScoreCard getScoreCardsByUserId(String userId)
    {
        ScoreCard card = repository.findById(userId).orElse(null);
        if (card == null)
        {
            return null; // or throw an exception if preferred
        }
        return repository.findById(userId).orElse(null); // ก็อาจจะต้องใช้มั้ง

    }

    public ScoreSummary getScoreSummary(String scoreCardId) {
        ScoreCard card = repository.findById(scoreCardId).orElseThrow(() ->
                new NoSuchElementException("ScoreCard not found"));

        int totalScore = 0;
        int totalIn = 0;
        int totalOut = 0;

        for (Score score : card.getScore()) {
            totalScore += score.getScore();
            if (score.getHoleNo() >= 1 && score.getHoleNo() <= 9) {
                totalIn += score.getScore();
            } else if (score.getHoleNo() >= 10 && score.getHoleNo() <= 18) {
                totalOut += score.getScore();
            }
        }

        ScoreSummary summary = new ScoreSummary();
        summary.setTotalScore(totalScore);
        summary.setTotalIn(totalIn);
        summary.setTotalOut(totalOut);

        return summary;
    }

}
//