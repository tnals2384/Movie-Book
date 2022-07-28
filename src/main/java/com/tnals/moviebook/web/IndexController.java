package com.tnals.moviebook.web;

import com.tnals.moviebook.domain.movies.MoviesRepository;
import com.tnals.moviebook.service.MoviesService;
import com.tnals.moviebook.web.dto.MoviesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MoviesService moviesService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/movies")
    public String moviesIndex(Model model) {
        model.addAttribute("movies", moviesService.findAllDesc());

        return "movies-index";
    }

    @GetMapping("/movies/save")
    public String moviesSave() {
        return "movies-save";
    }

    @GetMapping("/movies/update/{id}")
    public String moviesUpdate(@PathVariable Long id, Model model) {
        MoviesResponseDto dto = moviesService.findById(id);
        model.addAttribute("movie",dto);

        return "movies-update.mustache";
    }
}
