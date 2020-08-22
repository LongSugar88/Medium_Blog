package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Comment> comments;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Image> images;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<Blog> blogs;


}
