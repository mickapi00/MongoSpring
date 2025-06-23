package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.Marker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface MarkerRepo extends MongoRepository<Marker,String> {

    List<Marker> findByCourseLayoutId(String courseLayoutId);

}



