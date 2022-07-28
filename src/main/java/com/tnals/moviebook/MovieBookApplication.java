package com.tnals.moviebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing

@SpringBootApplication
public class MovieBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookApplication.class, args);
    }

}
