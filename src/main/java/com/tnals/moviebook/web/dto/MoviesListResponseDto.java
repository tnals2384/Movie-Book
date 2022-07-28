package com.tnals.moviebook.web.dto;

import com.tnals.moviebook.domain.movies.Movies;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MoviesListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public MoviesListResponseDto(Movies entity) {
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.author=entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();

    }
}