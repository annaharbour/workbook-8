package pluralsight.ui;

import pluralsight.dao.ActorDao;
import pluralsight.dao.FilmDao;
import pluralsight.models.Actor;
import pluralsight.models.Film;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class Search {

    public static void displayActors(DataSource dataSource) {
        ActorDao actorDao = new ActorDao(dataSource);
        List<Actor> actors = actorDao.getAll();
        if (actors.isEmpty()) {
            System.out.println("No actors found");
        } else {
            actors.forEach(System.out::println);
        }
    }

    public static void searchActors(Scanner scanner, DataSource dataSource) {
        System.out.println("Enter the first name of the actor: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the actor: ");
        String lastName = scanner.nextLine();

        ActorDao actorDao = new ActorDao(dataSource);
        List<Actor> actors = actorDao.getByName(firstName, lastName);

        if (actors.isEmpty()) {
            System.out.println("No actors found");
        } else {
            actors.forEach(System.out::println);
        }
    }

    public static void searchFilms(Scanner scanner, DataSource dao) {
        System.out.println("Enter the ID of the actor to view their films: ");
        int actorId = scanner.nextInt();
        FilmDao filmDao = new FilmDao(dao);
        List<Film> films = filmDao.searchByActor(actorId);
        if (films.isEmpty()) {
            System.out.println("No films found for the given actor ID.");
        } else {
            films.forEach(System.out::println);
        }
    }
}
