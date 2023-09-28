package dev.shahin.movies.controller;

import dev.shahin.movies.controller.MovieController;
import dev.shahin.movies.entity.Movie;
import dev.shahin.movies.entity.MovieCreateDTO;
import dev.shahin.movies.entity.MovieGetDTO;
import dev.shahin.movies.entity.MovieSingleDTO;
import dev.shahin.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovies() {
        List<MovieGetDTO> movieList = new ArrayList<>();
        when(movieService.getAllMovies()).thenReturn(movieList);

        ResponseEntity<List<MovieGetDTO>> response = movieController.getMovies();

        verify(movieService).getAllMovies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movieList, response.getBody());
    }

    @Test
    public void testGetSingleMovie() {
        ObjectId movieId = new ObjectId();

        MovieSingleDTO movieSingleDTO = new MovieSingleDTO();
        when(movieService.getSingleMovie(movieId)).thenReturn(movieSingleDTO);

        ResponseEntity<MovieSingleDTO> response = movieController.getSingleMovie(movieId);

        verify(movieService).getSingleMovie(movieId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movieSingleDTO, response.getBody());
    }

    @Test
    public void testDeleteMovie() {
        ObjectId movieId = new ObjectId();

        when(movieService.deleteMovie(movieId)).thenReturn(Long.valueOf(1L));

        ResponseEntity<Long> response = movieController.deleteMovie(movieId);

        verify(movieService).deleteMovie(movieId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Long.valueOf(1L), response.getBody());
    }





    @Test
    public void testCreateMovie() {
        // Create a MovieCreateDTO for testing
        MovieCreateDTO createDTO = new MovieCreateDTO();
        // Mock the behavior of movieService.createMovie() to return a Movie object
        Movie createdMovie = new Movie();
        when(movieService.createMovie(createDTO)).thenReturn(createdMovie);

        // Call the controller method
        ResponseEntity<Movie> response = movieController.createMovie(createDTO);

        // Verify that the service method was called and the response is as expected
        verify(movieService).createMovie(createDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdMovie, response.getBody());
    }
}
