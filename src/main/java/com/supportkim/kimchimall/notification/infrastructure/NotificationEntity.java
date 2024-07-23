package com.supportkim.kimchimall.notification.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;
}
