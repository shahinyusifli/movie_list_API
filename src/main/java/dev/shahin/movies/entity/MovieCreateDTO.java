package dev.shahin.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("movies")
public class MovieCreateDTO {
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private  String poster;
    private List<String> genres;
}
