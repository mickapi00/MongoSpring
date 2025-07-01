package com.example.MongoSpring.Model;


import lombok.Data;

@Data
public class ScoreSummary {

    private String courseName;

    private String markerId;

    private Integer totalScore;

    private Integer totalIn;

    private Integer totalOut;

    private Integer totalHandicap;

    // Additional fields can be added as needed
    // For example, you might want to include a list of scores or other summary statistics


}
