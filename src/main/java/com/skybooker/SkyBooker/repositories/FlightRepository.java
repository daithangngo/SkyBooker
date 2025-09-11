package com.skybooker.SkyBooker.repositories;

import com.skybooker.SkyBooker.entities.Flight;
import com.skybooker.SkyBooker.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    boolean existsByFlightNumber(String flightNumber);

    List<Flight> findByDepartureAirport_IataCodeAndArrivalAirport_IataCodeAndStatusAndDepartureTimeBetween(
            String departureIataCode,
            String arrivalIataCode,
            FlightStatus status,
            LocalDateTime start,
            LocalDateTime end);
}
