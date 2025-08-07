package com.example.MongoSpring.Model;

//import com.example.MongoSpring.Repository.ScoreCardRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;
@Document (collection = "scoreCard") // Specify the collection name in MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard
{
    @Id

    private String _id;

    private String teeOffDate;

    private String frontmarkersId;

    private String backmarkersId;

    private String courseName; // ดึงมาได้จาก state

    private Integer totalScore;   // frontend manage เเล้ว map มา

    private Integer totalIn; // frontend manage

    private Integer totalOut; // frontend manage

    @Field
    private List<Score> score; // frontend manage


}
