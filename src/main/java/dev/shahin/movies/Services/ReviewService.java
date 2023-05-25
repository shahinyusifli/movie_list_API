package dev.shahin.movies.Services;

import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.Review;
import dev.shahin.movies.Repositories.ReviewRepository;
import dev.shahin.movies.Utilities.CheckReview;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String body, String id) {
        CheckReview checkReview = new CheckReview(body);
        Review review = reviewRepository.insert(new Review(checkReview.dumyDetectTestReview()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
