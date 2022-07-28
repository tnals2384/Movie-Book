package com.tnals.moviebook.web.dto;

import com.tnals.moviebook.domain.movies.Movies;
import com.tnals.moviebook.domain.movies.MoviesRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MoviesResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public MoviesResponseDto(Movies entity) {
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }
}

