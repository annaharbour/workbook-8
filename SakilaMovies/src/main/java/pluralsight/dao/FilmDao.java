package pluralsight.dao;

import pluralsight.models.Film;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    private DataSource dataSource;

    public FilmDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM film";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("film_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int releaseYear = resultSet.getInt("release_year");
                int length = resultSet.getInt("length");
                films.add(new Film());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return films;
    }

    public List<Film> searchByActor(int actorId) {
        List<Film> films = new ArrayList<>();
        String query = "SELECT film.film_id, film.title, film.description, film.release_year, film.length " +
                "FROM film " +
                "JOIN film_actor ON film_actor.film_id = film.film_id " +
                "WHERE film_actor.actor_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, actorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("film_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int releaseYear = resultSet.getInt("release_year");
                    int length = resultSet.getInt("length");
                    films.add(new Film(id, title, description, releaseYear, length));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return films;
    }
}
