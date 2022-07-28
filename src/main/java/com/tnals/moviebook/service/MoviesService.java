package com.tnals.moviebook.service;

import com.tnals.moviebook.domain.movies.Movies;
import com.tnals.moviebook.domain.movies.MoviesRepository;
import com.tnals.moviebook.web.dto.MoviesListResponseDto;
import com.tnals.moviebook.web.dto.MoviesResponseDto;
import com.tnals.moviebook.web.dto.MoviesSaveRequestDto;
import com.tnals.moviebook.web.dto.MoviesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Transactional
    public Long save(MoviesSaveRequestDto requestDto) {
        return moviesRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MoviesUpdateRequestDto requestDto) {
        Movies movies = moviesRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        movies.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Movies movies = moviesRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        moviesRepository.delete(movies);
    }

    public MoviesResponseDto findById(Long id) {
        Movies entity = moviesRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new MoviesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MoviesListResponseDto> findAllDesc() {
        return moviesRepository.findAllDesc().stream()
                .map(MoviesListResponseDto::new)
                .collect(Collectors.toList());
    }
}

