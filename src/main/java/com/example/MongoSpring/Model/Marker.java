package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "markers")

public class Marker {

    @Id
    private String id;

    private String courseName;

    private String markersId;

    private String courseLayoutId;

    private String color;

    private String colorCode;

    private Integer totalPar;

    private Integer totalDistance;


    @Field("markersDetails")

    private List<MarkerDetails> markerDetails; // รายละเอียดของ Marker เช่น ระยะทาง, พาร์, ฯลฯ



}
