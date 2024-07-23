package com.supportkim.kimchimall.member.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
}
