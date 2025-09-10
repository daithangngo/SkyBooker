package com.skybooker.SkyBooker.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {
    @NotNull(message = "Flight Id cannot be null")
    private Long flightId;

    @NotEmpty(message = "At least one passenger required")
    private List<PassengerDTO> passengers;
}
