package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "markersDetails")

public class MarkerDetails {


    private Integer holeNo;

    private Integer distance;

    private Integer parNo;

    private Integer handicap;
}