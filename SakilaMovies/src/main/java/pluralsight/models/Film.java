package pluralsight.models;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film {
    private @Getter @Setter int filmId;
    private @Getter @Setter String title;
    private @Getter @Setter String description;
    private @Getter @Setter int releaseYear;
    private @Getter @Setter int length;
}