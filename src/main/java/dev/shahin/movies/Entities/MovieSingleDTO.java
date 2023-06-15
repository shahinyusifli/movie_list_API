package dev.shahin.movies.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieSingleDTO {
    private String title;
    private String releaseDate;
    private long totalNumOfReviews;
}
