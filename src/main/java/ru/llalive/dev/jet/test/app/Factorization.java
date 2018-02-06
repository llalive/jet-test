package ru.llalive.dev.jet.test.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class Factorization implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        System.out.println("Введите целое число для разложения на простые множители:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            if (isSimple(number)) {
                System.out.println("Введено простое число. Множители 1 и " + number);
            } else {
                while(!isSimple(number)){
                    for (int i = 2; i < number; i++) {
                        if(number % i == 0){
                            number = number / i;
                            arr.add(i);
                            break;
                        }
                    }
                    arr.add(number);
                }
                System.out.println("Множители: " + arr.toString());
            }
        }
    }

    

    private static boolean isSimple(long number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
