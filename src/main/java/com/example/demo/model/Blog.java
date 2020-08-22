package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "create_date", nullable = false)
    private Timestamp createDate = Timestamp.valueOf(LocalDateTime.now());

    @Column(nullable = false)
    private String content;

    private Integer blog_like = 0;

    private Integer blog_view = 0;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Account account;





}
