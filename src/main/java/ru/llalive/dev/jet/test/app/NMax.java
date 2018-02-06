package ru.llalive.dev.jet.test.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class NMax implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        System.out.println("Программа находит N-ое по величине значение из набора чисел.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение N:");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        System.out.println("Вводите числа по 1-му на строку. Для окончания ввода введите любую букву.");
        List<Float> numbers = new ArrayList<>();
        while (scanner.hasNextFloat()) {
            numbers.add(scanner.nextFloat());
        }
        if (numbers.isEmpty()) {
            System.err.println("Набор чисел пуст.");
        } else if (numbers.size() < n) {
            System.err.println("Размер массива чисел меньше N.");
        } else if (n <= 0) {
            System.err.println("N должно быть больше нуля.");
        } else {
            Arrays.sort(numbers.toArray());
            System.out.println("N-ое по величине число: " + numbers.get(n - 1));
        }
    }

}
