package pluralsight;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Product;
import pluralsight.ui.HomeScreen;
import pluralsight.ui.ScreenState;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NorthwindDao dao = new NorthwindDao();
        ScreenState currentScreen = new HomeScreen();
        while (currentScreen != null) {
            currentScreen.display(dao);
            currentScreen = currentScreen.handleInput(scanner);
        }
        System.out.println("Goodbye");
    }
}