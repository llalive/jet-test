package ru.llalive.dev.jet.test.app;

import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class Decoder implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для декодирования:");
        String input = scanner.next();
        if (input.matches("^(\\d\\w)+$")) {
            String[] split = input.split("");
            for (int j = 0; j < split.length - 1; j = j + 2) {
                Integer repeat = Integer.parseInt(split[j]);
                while (repeat > 0) {
                    System.out.print(split[j + 1]);
                    repeat--;
                }
            }
        } else {
            System.out.println("Невалидная строка для декодирования");
        }
    }

}
