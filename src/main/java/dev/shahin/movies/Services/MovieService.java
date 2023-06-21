package dev.shahin.movies.Services;

import com.mongodb.client.result.UpdateResult;
import dev.shahin.movies.Entities.*;
import dev.shahin.movies.MoviesApplication;
import dev.shahin.movies.Repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<MovieGetDTO> getAllMovies() {
        Query query =new Query();
        query.addCriteria(Criteria.where("flag").is(false));
        query.fields()
                .include("title")
                .include("releaseDate")
                .include("genres")
                .include("poster");
        return mongoTemplate.find(query, MovieGetDTO.class);
    }

    public MovieSingleDTO getSingleMovie(ObjectId id) {
        Query query =new Query();
        query.addCriteria(Criteria.where("id").is(id));
        query.addCriteria(Criteria.where("flag").is(false));
        query.fields()
                .include("title")
                .include("releaseDate")
                .include("reviewIds");

        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        Movie movie = movies.get(0);
        List<Review> reviewIds = movie.getReviewIds();

        MovieSingleDTO movieSingleDTO = MovieSingleDTO
                .builder()
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .totalNumOfReviews(reviewIds
                        .stream()
                        .count()
                ).build();
        return movieSingleDTO;
    }

    public MovieWithReviewsDTO getMoviesWithReviews() {
        Query query = new Query();
        query.addCriteria(Criteria.where("flag").is(false));
        query.fields()
                .include("title")
                .include("poster")
                .include("genres")
                .include("reviews")
                .include("releaseDate");

        List<Movie> movies = mongoTemplate.find(query, Movie.class);

        return (MovieWithReviewsDTO) movies;
    }

    public Long deleteMovie(ObjectId id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        query.addCriteria(Criteria.where("reviewIds").size(0));
        Update updateDefinition = new Update().set("flag", true);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, Movie.class);
        return updateResult.getMatchedCount();
    }

    public Movie createMovie(MovieCreateDTO payload) {

        Movie movie = new Movie();

        Set<Integer> unique_no_list = new Random()
                .ints(0, 9)
                .distinct()
                .limit(5)
                .boxed()
                .collect(Collectors.toSet());

        String generatedNumbersOfImdbId = unique_no_list
                .stream()
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining(""));

        String generatedLettersOfID = payload.getGenres() != null
                ? payload.getGenres().stream()
                .map(x -> String.valueOf(x.charAt(0)))
                .collect(Collectors.joining(""))
                : "oth";

        String generatedImdbId = generatedLettersOfID.concat(generatedNumbersOfImdbId);

        List<String> emptyGenres = new ArrayList<>();
        List<Review> emptyReviews = new ArrayList<>();

        movie.setImdbId(Optional.ofNullable(payload.getImdbId()).orElse(generatedImdbId));
        movie.setTitle(payload.getTitle());
        movie.setReleaseDate(payload.getReleaseDate());
        movie.setTrailerLink(payload.getTrailerLink());
        movie.setPoster(payload.getPoster());
        movie.setGenres(payload.getGenres());
        movie.setBackdrops(emptyGenres);
        movie.setReviewIds(emptyReviews);
        movie.setFlag(false); // Set flag to false

        Movie savedMovie = movieRepository.insert(movie);
        return savedMovie;
    }
}
