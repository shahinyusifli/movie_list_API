package dev.shahin.movies.Repositories;

import dev.shahin.movies.Entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //@Query("{'flag': false}")
    @Query("{'flag': false}")
    List<Movie> findAllByFlagFalse();
}
