package com.tnals.moviebook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MoviesUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public MoviesUpdateRequestDto(String title, String content) {
        this.title =title;
        this.content=content;
    }
}
