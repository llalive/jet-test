package ru.llalive.dev.jet.test.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class SecondMax implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        System.out.println("Программа находит второе по величине значение из набора чисел.");
        System.out.println("Вводите числа по 1-му на строку. Для окончания ввода введите любую букву.");
        Scanner scanner = new Scanner(System.in);
        List<Float> numbers = new ArrayList<>();
        while (scanner.hasNextFloat()) {
            numbers.add(scanner.nextFloat());
        }
        if (numbers.size() < 2) {
            System.err.println("Набор чисел должен содержать минимум 2 числа.");
        } else {
            Float max = numbers.get(0);
            Float secondMax = numbers.get(0);
            for (Float number : numbers) {
                if (max < number) {
                    secondMax = max;
                    max = number;
                } else if (number > secondMax) {
                    secondMax = number;
                }
            }
            System.out.println("Второе по величине число: " + secondMax);
        }
    }

}
