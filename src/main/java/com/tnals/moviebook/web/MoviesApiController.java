package com.tnals.moviebook.web;

import com.tnals.moviebook.service.MoviesService;
import com.tnals.moviebook.web.dto.MoviesResponseDto;
import com.tnals.moviebook.web.dto.MoviesSaveRequestDto;
import com.tnals.moviebook.web.dto.MoviesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MoviesApiController {

    private final MoviesService moviesService;

    @PostMapping("/api/v1/movies")
    public Long save(@RequestBody MoviesSaveRequestDto requestDto) {
        return moviesService.save(requestDto);
    }


    @GetMapping("/api/v1/movies/{id}")
    public MoviesResponseDto findById(@PathVariable Long id) {
        return moviesService.findById(id);
    }

    @PutMapping("/api/v1/movies/{id}")
    public Long update(@PathVariable Long id, @RequestBody MoviesUpdateRequestDto requestDto) {
        return moviesService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/movies/{id}")
    public Long delete(@PathVariable Long id) {
        moviesService.delete(id);
        return id;
    }

}
