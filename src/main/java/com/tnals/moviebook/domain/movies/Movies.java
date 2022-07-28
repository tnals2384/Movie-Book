package com.tnals.moviebook.domain.movies;

import com.tnals.moviebook.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class Movies extends BaseTimeEntity {

    @Id //키값
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=500,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Movies(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author =author;
    }

    public void update(String title, String content) {
        this.title= title;
        this.content =content;
    }

}
