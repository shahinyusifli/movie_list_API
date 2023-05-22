package dev.shahin.movies.Controlers;


import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Repositories.MovieRepository;
import dev.shahin.movies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
}
