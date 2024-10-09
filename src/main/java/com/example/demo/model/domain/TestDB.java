package com.example.demo.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "testdb")
@Data
public class TestDB {
    @Id  // 이게 primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;
}
