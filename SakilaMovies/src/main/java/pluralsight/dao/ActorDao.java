package pluralsight.dao;

import pluralsight.models.Actor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    private final DataSource dataSource;

    public ActorDao(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                actors.add(new Actor(id, firstName, lastName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public List<Actor> getByName(String first, String last) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor WHERE first_name LIKE ? AND last_name LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + first + "%");
            statement.setString(2, "%" + last + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("actor_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    actors.add(new Actor(id, firstName, lastName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
}