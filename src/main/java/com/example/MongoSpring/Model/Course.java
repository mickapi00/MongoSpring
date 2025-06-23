package com.example.MongoSpring.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collections;
import java.util.List;
import java.awt.*;

@Data
@Document (collection = "course")

public class Course
{
    @Id// ใช้ @Id เพื่อระบุว่าเป็น ID ของเอกสารใน MongoDB

    private String _id; // ID ของ Course


    private String courseId; // รหัสของสนามกอล์ฟ


    private String name;

}