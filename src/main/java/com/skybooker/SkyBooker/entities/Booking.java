package com.skybooker.SkyBooker.entities;

import com.skybooker.SkyBooker.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String bookingReference;

    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Flight flight;

    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @OneToMany
    private List<Passenger> passengers = new ArrayList<>();
}
