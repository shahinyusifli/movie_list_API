package dev.shahin.movies.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import dev.shahin.movies.controller.ReviewController;
import dev.shahin.movies.entity.Review;
import dev.shahin.movies.service.ReviewService;
import dev.shahin.movies.utility.Validation.ReviewDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public class ReviewControllerTest {

    private ReviewController reviewController;
    private ReviewService reviewService;
    private ReviewDTO reviewDTO;
    private Errors errors;

    @BeforeEach
    public void setUp() {
        reviewService = mock(ReviewService.class);
        reviewController = new ReviewController(reviewService);
        reviewDTO = new ReviewDTO();
        errors = mock(Errors.class);
    }

    @Test
    public void testCreateReview_ValidInput() {
        Review expectedReview = new Review();
        expectedReview.setId(1L);

        when(reviewService.createReview(any(), any())).thenReturn(expectedReview);

        ResponseEntity<Review> responseEntity = reviewController.createReview(reviewDTO, errors);

        verify(reviewService, times(1)).createReview(reviewDTO.getBody(), reviewDTO.getId());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(expectedReview, responseEntity.getBody());
    }

    @Test
    public void testCreateReview_InvalidInput() {
        when(errors.hasErrors()).thenReturn(true);
        ResponseEntity<Review> responseEntity = reviewController.createReview(reviewDTO, errors);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
