package dev.shahin.movies.Controlers;


import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.MovieCreateDTO;
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

    @PostMapping("/delete/{id}")
    public ResponseEntity<Long> deleteMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Long>(movieService.deleteMovie(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody MovieCreateDTO payload){
        return new ResponseEntity<Movie>(movieService.createMovie(payload), HttpStatus.CREATED);
    }

}
