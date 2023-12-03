package com.example.lab_week06.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    private long id;
    @ManyToOne
    @JoinColumn(name = "postID")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "userD")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parentID")
    private PostComment parent;
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @Column( columnDefinition = "tinyint(1)")
    private int published;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime publishedAt;
    @Column(columnDefinition = "TEXT")
    private String content;
}
