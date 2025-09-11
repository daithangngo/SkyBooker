package com.skybooker.SkyBooker.repositories;

import com.skybooker.SkyBooker.entities.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
}
