package dev.shahin.movies.Services;

import com.mongodb.client.result.UpdateResult;
import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.MovieGetDTO;
import dev.shahin.movies.Repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Movie> getSingleMovie(ObjectId id) { return movieRepository.findById(id); }

    public Long deleteMovie(ObjectId id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update updateDefinition = new Update().set("flag", true);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, Movie.class);
        return updateResult.getMatchedCount();
    }
}
