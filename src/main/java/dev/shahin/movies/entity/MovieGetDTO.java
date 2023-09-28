package dev.shahin.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieGetDTO {
    private String title;
    private String releaseDate;
    private List<String> genres;
    private String poster;
}
