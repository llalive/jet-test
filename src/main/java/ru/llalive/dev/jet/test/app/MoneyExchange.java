/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.llalive.dev.jet.test.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class MoneyExchange implements JetApp {

    private static final List<Integer> VALUES = new ArrayList<>();
    private final boolean FIXED_VALUES;
    
    private static int change;

    public MoneyExchange(boolean fixedValues) {
        this.FIXED_VALUES = fixedValues;
    }

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {

        Scanner scanner = new Scanner(System.in);

        if (!FIXED_VALUES) {

            System.out.println("Введите номиналы монет по 1 на строку (0 для окончания ввода): ");
            while (scanner.hasNext()) {
                int value = scanner.nextInt();
                if (value == 0) {
                    break;
                } else if (value == -1) {
                    System.out.println("Номинал не может быть отрицательным");
                } else if (VALUES.contains(value)) {
                    System.out.println("Номинал уже добавлен");
                } else {
                    VALUES.add(value);
                }
            }

            if (VALUES.isEmpty()) {
                System.out.println("Не задано ни одного номинала.");
                return;
            }

        }

        System.out.println("Введите сумму для размена: ");
        if (scanner.hasNext()) {
            change = scanner.nextInt();
        }

        if (change <= 0) {
            System.out.println("Некорректная сумма для размена.");
            return;
        }

        if (FIXED_VALUES) {
            VALUES.add(3);
            VALUES.add(5);
            System.out.println("Размен на 3 и 5 копеек:");
            calculateCombinations();
            VALUES.add(7);
            System.out.println("Размен на 3, 5 и 7 копеек:");
            calculateCombinations();
        } else {
            System.out.println("Варианты размена суммы:");
            calculateCombinations();
        }
    }

    private static void calculateCombinations() {

        //берём число и делим его на минимальное значение из массива
        //получаем максимальное кол-во монет для составления набора
        int minValue = VALUES.get(0);
        int maxValue = VALUES.get(VALUES.size() - 1);

        int maxCoins = change / minValue;

        //определим минимально необходимое кол-во монет для составления набора
        int minCoins = (int) Math.ceil((double) change / maxValue);

        for (int i = minCoins; i <= maxCoins; i++) {
            int[] output = fillArrayWithNumber(minValue, i);
            if (getSum(output) == change) {
                System.out.println(Arrays.toString(output));
            }
            while (!isMaxArray(output, maxValue)) {
                output = getNext(output, VALUES);
                int sum = getSum(output);
                if (sum == change) {
                    System.out.println(Arrays.toString(output));
                }
            }
        }
    }

    private static int[] getNext(int arr[], List<Integer> values) {
        for (int j = 1; j <= arr.length; j++) {
            int last = arr[arr.length - j]; //берём число в последнем разряде
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) == last) { // нашли номинал
                    if (i == values.size() - 1) { //если достигнуто макс. значение номинала в разряде
                        //устанавливаем значение на минимальное и переходим к следующему разряду
                        //arr[arr.length - j] = arr[0];
                    } else {
                        //увеличиваем значение и все последующие и выходим
                        for (int k = arr.length - j; k < arr.length; k++) {
                            arr[k] = values.get(i + 1);
                        }
                        return arr;
                    }
                }
            }
        }
        return arr;
    }

    private static int getSum(int[] row) {
        int sum = 0;
        for (int r : row) {
            sum += r;
        }
        return sum;
    }

    private static int[] fillArrayWithNumber(int value, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
        return arr;
    }

    private static boolean isMaxArray(int[] output, int maxValue) {
        for (int i = 0; i < output.length; i++) {
            if (output[i] != maxValue) {
                return false;
            }
        }
        return true;
    }

}
