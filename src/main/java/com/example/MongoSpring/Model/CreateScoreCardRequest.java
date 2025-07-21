package com.example.MongoSpring.Model;

import lombok.Data;
import org.apache.catalina.util.Introspection;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Test/apitest")
@Data

public class CreateScoreCardRequest

{


    private String courseName;

    private String markerId;


}


