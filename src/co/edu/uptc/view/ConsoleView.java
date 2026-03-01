package co.edu.uptc.view;

import java.util.Scanner;
import co.edu.uptc.interfaces.IView;

public class ConsoleView implements IView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public String read(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}