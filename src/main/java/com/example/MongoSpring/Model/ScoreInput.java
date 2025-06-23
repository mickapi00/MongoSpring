package com.example.MongoSpring.Model;

import lombok.Data;

@Data
public class ScoreInput
{

    private String courseId;


    private String courseLayoutId;


    private Integer score;


    private Integer holeNo; // Hole number for the score

}
