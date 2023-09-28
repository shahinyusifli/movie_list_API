package dev.shahin.movies.service;

import dev.shahin.movies.entity.Movie;
import dev.shahin.movies.entity.MovieSingleDTO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSingleMovie() {
        ObjectId objectId = new ObjectId();

        Movie movie = new Movie();
        movie.setReviewIds(new ArrayList<>());

        when(mongoTemplate.find(any(Query.class), eq(Movie.class))).thenReturn(List.of(movie));

        MovieSingleDTO result = movieService.getSingleMovie(objectId);

        verify(mongoTemplate, times(1)).find(any(Query.class), eq(Movie.class));
    }
}
