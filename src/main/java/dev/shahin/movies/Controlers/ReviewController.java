package dev.shahin.movies.Controlers;

import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.Review;
import dev.shahin.movies.Services.ReviewService;
import dev.shahin.movies.Utilities.Validation.ReviewDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/review/create")
public class ReviewController {
@Autowired
    private ReviewService reviewService;
@PostMapping
    public ResponseEntity<Review> createReview(@RequestBody @Validated ReviewDTO payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.getBody(), payload.getId()), HttpStatus.CREATED);
    }
}
