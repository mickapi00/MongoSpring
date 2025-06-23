package com.example.MongoSpring.Repository;

import com.example.MongoSpring.Model.MarkerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MarkerDetailsRepo extends MongoRepository<MarkerDetails, String>

{
    List<MarkerDetails> findByMarkersId(String markersId);
    List<MarkerDetails> findByMarkersIdAndHoleNo(String markersId, Integer holeNo);
}
