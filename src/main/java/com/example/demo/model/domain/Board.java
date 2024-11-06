package com.example.demo.model.domain;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;
    @Column(name="title", nullable = false)
    private String title = "";
    @Column(name="content", nullable = false)
    private String content = "";
    @Column(name="user", nullable = false)
    private String user = "";
    @Column(name="newdate", nullable = false)
    private String newdate = "";
    @Column(name="count", nullable = false)
    private String count = "";
    @Column(name="likec", nullable = false)
    private String likec = "";
    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}