package com.example.MongoSpring.Model;

import com.example.MongoSpring.Repository.ScoreCardRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
@Document (collection = "scoreCard") // Specify the collection name in MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard

{
    @Id // _id is the primary key of the document

    private String  id;

    private String userId;// userId is the ID of the user who created the scorecard นำมาจากดึง api บลาๆ

    private String userName; // มาจากดึง api บลาๆ

    private LocalDate teeOffDate;

    private String courseId; // ดึงมาได้ จาก state

    private String courseName; // ดึงมาได้จาก state

    private Integer totalScore;   // frontend manage เเล้ว map มา

    private Integer totalIn; // frontend manage

    private Integer totalOut; // frontend manage

    private LocalDate createdDate;

    private LocalDate createdBy;

    private LocalDate updatedDate;

    private String updatedBy;

    private Integer reserveId;

    private List<Score> score; // frontend manage




}
