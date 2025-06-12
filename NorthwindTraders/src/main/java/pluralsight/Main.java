package pluralsight;

import pluralsight.dao.NorthwindDao;
import pluralsight.ui.HomeScreen;
import pluralsight.ui.ScreenState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NorthwindDao dao = new NorthwindDao();
        ScreenState currentScreen = new HomeScreen();
        while (currentScreen != null) {
            currentScreen.display(dao);
            currentScreen = currentScreen.handleInput(scanner, dao);
        }
        System.out.println("Goodbye");
    }
}