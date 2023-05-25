package dev.shahin.movies.Controlers;

import dev.shahin.movies.Entities.Movie;
import dev.shahin.movies.Entities.Review;
import dev.shahin.movies.Services.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("body"), payload.get("id")), HttpStatus.CREATED);
    }
}
