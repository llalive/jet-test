package ru.llalive.dev.jet.test.app;

import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class Encoder implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        System.out.println("Введите строку для кодирования:");

        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();

        System.out.println("Кодированная строка: " + encodeString(source));
    }

    private static String encodeString(String source) {
        String encoded = "";
        source = sortString(source);
        int count = 1;
        for (int i = 0; i <= source.length() - 1; i++) {
            char c = source.charAt(i);
            if (i != source.length() - 1 && c == source.charAt(i + 1)) {
                count++;
            } else {
                encoded += count + String.valueOf(c);
                count = 1;
            }
        }
        return encoded;
    }

    private static String sortString(String source) {
        boolean sorted = false;
        char[] charArr = source.toCharArray();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < charArr.length - 1; i++) {
                if (charArr[i] > charArr[i + 1]) {
                    char tmp = charArr[i];
                    charArr[i] = charArr[i + 1];
                    charArr[i + 1] = tmp;
                    sorted = false;
                }
            }
        }
        return new String(charArr);
    }

}
