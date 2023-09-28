package dev.shahin.movies.repository;

import dev.shahin.movies.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    @Query("{'flag': false}, {'title': 1, 'releaseDate': 1}")
    List<Movie> findAllByFlagFalse();
}
