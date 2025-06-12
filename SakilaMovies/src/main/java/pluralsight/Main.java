package pluralsight;

import pluralsight.dao.DataManager;
import pluralsight.ui.HomeScreen;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager();
        dataManager.getConnection();
        DataSource dao = DataManager.getDataSource();
        HomeScreen.run(scanner, dao);
        System.out.println("Exiting the application. Goodbye!");
    }
}