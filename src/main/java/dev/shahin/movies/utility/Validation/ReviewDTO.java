package dev.shahin.movies.utility.Validation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@Collation()
public class ReviewDTO {
    @NotEmpty(message = "It should not be empty")
    @Size(min = 5, max = 50, message = "Size of review should be more than 5 and less than 50")
    private String body;
    @Id
    private String id;
}
