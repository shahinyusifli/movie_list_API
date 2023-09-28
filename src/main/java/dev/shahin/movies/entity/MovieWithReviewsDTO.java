package dev.shahin.movies.entity;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
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
