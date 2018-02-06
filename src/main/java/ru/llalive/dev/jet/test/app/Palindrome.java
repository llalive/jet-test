package ru.llalive.dev.jet.test.app;

import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class Palindrome implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        System.out.println("Является ли строка палиндромом. Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String line = scanner.nextLine();
            String reversed = getReversed(line);
            System.out.println("Строка "
                    + (line.equals(reversed) ? "является" : "не является")
                    + " палиндромом.");
        }
    }

    private static String getReversed(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

}
