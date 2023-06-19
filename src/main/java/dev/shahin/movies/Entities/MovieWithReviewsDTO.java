package dev.shahin.movies.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieWithReviewsDTO {
    private String title;
    private  String poster;
    private List<String> genres;
    private List<String> reviews;
    private String releaseDate;
}
