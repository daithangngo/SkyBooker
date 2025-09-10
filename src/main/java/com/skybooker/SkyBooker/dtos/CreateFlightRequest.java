package com.skybooker.SkyBooker.dtos;

import com.skybooker.SkyBooker.entities.Airport;
import com.skybooker.SkyBooker.enums.FlightStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {

    private Long id;

    private FlightStatus status;

    @NotBlank(message = "Flight Number required")
    private String flightNumber;

    @NotBlank(message = "Departure Airport Iata Code required")
    private String departureAirportIataCode;

    @NotBlank(message = "Arrival Airport Iata Code required")
    private String arrivalAirportIataCode;

    @NotNull(message = "Departure Time cannot be null")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival Time cannot be null")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Base Price cannot be null")
    @Positive(message = "Base Price must be positive")
    private BigDecimal basePrice;

    private Long pilotId;
}
