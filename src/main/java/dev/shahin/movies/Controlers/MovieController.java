package dev.shahin.movies.Controlers;


import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.MovieGetDTO;
import dev.shahin.movies.Repositories.MovieRepository;
import dev.shahin.movies.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<MovieGetDTO>> getMovies() {
        return new ResponseEntity<List<MovieGetDTO>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(id), HttpStatus.OK);
    }
}
