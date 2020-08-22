package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Account account;
}
