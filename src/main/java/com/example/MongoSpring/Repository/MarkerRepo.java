package com.example.MongoSpring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoSpring.Model.Marker;


public interface MarkerRepo extends MongoRepository<Marker,String> {

    List<Marker> findByCourseLayoutId(String courseLayoutId);

    List<Marker> findByMarkersId(String markerId);



}



