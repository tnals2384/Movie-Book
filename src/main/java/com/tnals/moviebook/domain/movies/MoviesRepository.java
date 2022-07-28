package com.tnals.moviebook.domain.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

    @Query("SELECT p FROM Movies p ORDER BY p.id DESC")
    List<Movies> findAllDesc();
}
