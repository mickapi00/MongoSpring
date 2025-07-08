package com.example.MongoSpring.Model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class UpdateMarker {

    @Id
    private String id;

    private String markersId;

    private String courseName;

    private String courseLayoutId;





}
