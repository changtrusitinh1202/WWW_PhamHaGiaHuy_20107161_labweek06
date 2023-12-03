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
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parentID")
    private Post parent;
    @ManyToOne
    @JoinColumn(name = "authorID")
    private User author;
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @Column(columnDefinition = "varchar(200)")
    private String metaTitle;
    @Column(columnDefinition = "tinytext")
    private String summary;
    @Column(columnDefinition = "tinyint(1)")
    private int published;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime publishedAt;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;
    @Column
    private String content;

    public Post(Long id) {
        this.id = id;
    }

    public Post(User author, String title, String metaTitle, String summary, int published, LocalDateTime createdAt, LocalDateTime publishedAt, LocalDateTime updatedAt, String content) {
        this.author = author;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }
}
