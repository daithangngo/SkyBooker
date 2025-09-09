package com.skybooker.SkyBooker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
}
