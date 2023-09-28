package dev.shahin.movies.service;

import dev.shahin.movies.entity.Movie;
import dev.shahin.movies.entity.Review;
import dev.shahin.movies.repository.ReviewRepository;
import dev.shahin.movies.utility.CheckReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

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
                .apply(new Update().push("reviewIds").value(review.getReviewId()))
                .first();

        return review;
    }
}
