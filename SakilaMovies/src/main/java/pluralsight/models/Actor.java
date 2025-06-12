package pluralsight.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return String.format("%s. %s %s", actorId, firstName, lastName);
    }
}
