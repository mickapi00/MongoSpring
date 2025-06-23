package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "markers")
public class Marker {

    @Id
    private String id;

    private String markersId;

    private String courseLayoutId;

    private String color;

    private String colorcode;

    private Integer inPar;

    private Integer outPar;

    private Integer totalPar;

    private Integer totalDistance;

}
