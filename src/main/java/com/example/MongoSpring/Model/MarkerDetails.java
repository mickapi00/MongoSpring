package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "markersDetails")
public class MarkerDetails {

    @Id

    private String id;

    private String courseName;

    private String markersId;

    private Integer holeNo;

    private Integer distance;

    private Integer parNo;

    private Integer handicap;
}