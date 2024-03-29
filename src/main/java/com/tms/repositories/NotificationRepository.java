package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
