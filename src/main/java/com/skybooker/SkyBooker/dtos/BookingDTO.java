package com.skybooker.SkyBooker.dtos;

import com.skybooker.SkyBooker.entities.Flight;
import com.skybooker.SkyBooker.entities.Passenger;
import com.skybooker.SkyBooker.entities.User;
import com.skybooker.SkyBooker.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long id;

    private String bookingReference;

    private User user;

    private Flight flight;

    private LocalDateTime bookingDate;

    private FlightStatus status;

    private List<Passenger> passengers;
}
