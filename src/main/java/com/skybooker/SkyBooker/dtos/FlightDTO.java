package com.skybooker.SkyBooker.dtos;

import com.skybooker.SkyBooker.entities.Airport;
import com.skybooker.SkyBooker.entities.Booking;
import com.skybooker.SkyBooker.entities.User;
import com.skybooker.SkyBooker.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private Long id;

    private String flightNumber;

    private FlightStatus status;

    private Airport departureAirport;

    private Airport arrivalAirport;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private BigDecimal basePrice;

    private UserDTO assignedPilot;

    private List<BookingDTO> bookings;

    private String departureAirportIataCode;

    private String arrivalAirportIataCode;

}
