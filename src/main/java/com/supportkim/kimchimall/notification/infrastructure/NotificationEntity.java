package com.supportkim.kimchimall.notification.infrastructure;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notification_id")
    private Long id;

    private String message;
}
