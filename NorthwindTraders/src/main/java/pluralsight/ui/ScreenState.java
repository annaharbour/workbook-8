package pluralsight.ui;
import pluralsight.dao.NorthwindDao;

import java.util.Scanner;

public interface ScreenState {
    void display(NorthwindDao dao);
    ScreenState handleInput(Scanner scanner, NorthwindDao dao);
}