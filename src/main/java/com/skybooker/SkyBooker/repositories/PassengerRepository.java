package com.skybooker.SkyBooker.repositories;

import com.skybooker.SkyBooker.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
