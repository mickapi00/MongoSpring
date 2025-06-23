package com.example.MongoSpring.Model;

import com.example.MongoSpring.Repository.ScoreCardRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard

{
    @Id // _id is the primary key of the document
    private String  id;

    private String userId;

    private String userName;

    private LocalDate teeOffDate;

    private String courseId;

    private String courseName;

    private Integer totalScore;

    private Integer totalIn;

    private Integer totalOut;

    private LocalDate createdDate;

    private LocalDate createdBy;

    private LocalDate updatedDate;

    private String updatedBy;

    private Integer reserveId;


}
