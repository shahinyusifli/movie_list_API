package dev.shahin.movies.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSingleDTO {
    private String title;
    private String releaseDate;
    private List<ObjectId> reviewIds;
}
