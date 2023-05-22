package dev.shahin.movies.Repositories;

import dev.shahin.movies.Entities.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositories extends MongoRepository<Movies, ObjectId> {
}
