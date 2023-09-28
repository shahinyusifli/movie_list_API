package dev.shahin.movies.service;

import com.mongodb.client.result.UpdateResult;
import dev.shahin.movies.entity.Movie;
import dev.shahin.movies.entity.MovieGetDTO;
import dev.shahin.movies.entity.MovieSingleDTO;

import org.bson.BsonValue;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testGetAllMovies() {

        List<MovieGetDTO> movieGetDTOList = new ArrayList<>();

        Query expectedQuery = new Query();
        expectedQuery.addCriteria(Criteria.where("flag").is(false));
        expectedQuery.fields()
                .include("title")
                .include("releaseDate")
                .include("genres")
                .include("poster");

        when(mongoTemplate.find(eq(expectedQuery), eq(MovieGetDTO.class))).thenReturn(movieGetDTOList);

        List<MovieGetDTO> result = movieService.getAllMovies();

        verify(mongoTemplate, times(1)).find(eq(expectedQuery), eq(MovieGetDTO.class));
    }

    @Test
    public void testDeleteMovie() {
        ObjectId objectId = new ObjectId();
        Movie movie = new Movie();

        when(mongoTemplate.updateFirst(any(Query.class), any(Update.class), eq(Movie.class)))
                .thenReturn(new UpdateResult() {
                    @Override
                    public boolean wasAcknowledged() {
                        return false;
                    }

                    @Override
                    public long getMatchedCount() {
                        return 0;
                    }

                    @Override
                    public long getModifiedCount() {
                        return 0;
                    }

                    @Override
                    public BsonValue getUpsertedId() {
                        return null;
                    }
                });
        Long result = movieService.deleteMovie(objectId);
        verify(mongoTemplate, times(1)).updateFirst(any(Query.class), any(Update.class), eq(Movie.class));
        assertNotNull(result);
    }

}
