package com.example.lab_week06.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;



@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint(20)")
    private Long id;
    @Column(columnDefinition = "varchar(50)")
    private String firstName;
    @Column( columnDefinition = "varchar(50)")
    private String midName;
    @Column(columnDefinition = "varchar(50)")
    private String lastName;
    @Column(columnDefinition = "varchar(15)")
    private String mobile;
    @Column(columnDefinition = "varchar(50)")
    private String email;
    @Column(columnDefinition = "varchar(35)")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registeredAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastLogin;
    @Column(columnDefinition = "TINYTEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String profile;

    public User(Long id) {
        this.id = id;
    }
}
