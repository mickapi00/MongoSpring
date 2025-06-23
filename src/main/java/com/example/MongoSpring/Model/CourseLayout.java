package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document (collection = "alllayout")

public class CourseLayout
{

    @Id

    private String _id;

    private String courseId;

    private String courselayout;

    private String courselayoutId;

    private Integer totalPar;

}





