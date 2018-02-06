package ru.llalive.dev.jet.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ru.llalive.dev.jet.test.app.*;

/**
 * Интерфейс выбора задания
 *
 * @author babikov_pv
 */
public class JetMenu {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        while (scanner.hasNextInt()) {
            int choose = scanner.nextInt();
            JetApp jetApp;
            switch (choose) {
                case 1:
                    jetApp = new SecondMax();
                    break;
                case 2:
                    jetApp = new Factorization();
                    break;
                case 3:
                    jetApp = new Palindrome();
                    break;
                case 4:
                    jetApp = new MoneyExchange(true);
                    break;
                case 5:
                    jetApp = new Substring();
                    break;
                case 6:
                    jetApp = new NMax();
                    break;
                case 7:
                    jetApp = new Encoder();
                    break;
                case 8:
                    jetApp = new Decoder();
                    break;
                case 9:
                    jetApp = new MoneyExchange(false);
                    break;
                default:
                    return;
            }
            jetApp.begin();
            
            System.out.println("Введите любой символ и нажмите ENTER, чтобы продолжить.");
            scanner.next();
            
            printMenu();
        }
    }

    private static void printMenu() {
        
        List<String> menuItems = new ArrayList<>();
        
        menuItems.add("Выйти из программы");
        menuItems.add("Найти 2-ой по величине элемент набора чисел");
        menuItems.add("Разложить число на простые множители");
        menuItems.add("Является ли строка палиндромом");
        menuItems.add("Размен суммы на 3 / 5 и 3 / 5 / 7 копеек");
        menuItems.add("Поиск подстроки в строке");
        menuItems.add("Нахождение N-го по величине элемента в чисел");
        menuItems.add("Run-length encoding кодирование строки");
        menuItems.add("Run-length encoding декодирование строки");
        menuItems.add("Размен суммы на заданный номинал монет");
        
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
        System.out.println("----------------------\n"
                + "Введите номер задания:");
    }

}
