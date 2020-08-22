package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Blog blog;


}
