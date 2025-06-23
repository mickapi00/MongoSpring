package com.example.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
@Document
@Data
public class Reservation
{

    @Id
    private String id; //

    private String userId;

    private String scorecardId; //

    private LocalDate reservationDate;

    private Integer numberOfPlayers;

    public enum ReservationStatus {
        CONFIRMED,
        CANCELLED,
        PENDING
    }
    private ReservationStatus status; // สถานะการจอง เช่น "confirmed", "cancelled", "pending" //

}
