package dev.shahin.movies.controller;

import dev.shahin.movies.entity.Review;
import dev.shahin.movies.service.ReviewService;
import dev.shahin.movies.utility.Validation.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review/create")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody @Validated ReviewDTO payload, Errors errors) {
        if (errors.hasErrors()) {
            // If there are validation errors, return a 400 BAD_REQUEST response
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Review>(reviewService.createReview(payload.getBody(), payload.getId()), HttpStatus.CREATED);
    }

}
