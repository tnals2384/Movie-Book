package com.tnals.moviebook.web.dto;


import com.tnals.moviebook.domain.movies.Movies;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MoviesSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public MoviesSaveRequestDto(String title, String content,
                                String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Movies toEntity() {
        return Movies.builder()
                .title(title)
                .content(content)
                .author(author).build();
    }
}
