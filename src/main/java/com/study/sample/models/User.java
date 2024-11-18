package com.study.sample.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "users",indexes = @Index(columnList = "email"))
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private Roles role;

    @CreationTimestamp
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date created_on;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updated_on;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Column(name = "borrowed_list")
    private List<BookManager> bookManagers;
    
}
