/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.llalive.dev.jet.test.app;

import java.util.Scanner;

/**
 *
 * @author babikov_pv
 */
public class Substring implements JetApp {

    /**
     * @param args the command line arguments
     */
    @Override
    public void begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = scanner.next();
        if (s.isEmpty()) {
            System.out.println("Строка пустая.");
            return;
        }
        System.out.println("Введите подстроку для поиска:");
        String sub = scanner.next();
        int count = 0;
        while (s.contains(sub)) {
            s = s.replaceFirst(sub, "");
            count++;
        }
        System.out.println("Подстрока встречается " + count + " раз.");
    }

}
