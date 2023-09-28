package dev.shahin.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieSingleDTO {
    private String title;
    private String releaseDate;
    private long totalNumOfReviews;
}
