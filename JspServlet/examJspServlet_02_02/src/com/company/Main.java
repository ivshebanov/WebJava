package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Boolean> chikenList = new LinkedList<Boolean>();
        LinkedList<Boolean> fishList = new LinkedList<Boolean>();
        for (int i = 0; i < 10; i++) {
            chikenList.addLast(true);
            fishList.addLast(true);
        }
        System.out.println(chikenList);
        System.out.println(fishList);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (chikenList.size() != 0 || fishList.size() != 0) {
                System.out.println(chikenList.size());
                System.out.println(fishList.size());
                System.out.println("Вам курицу или рыбу?");
                switch (reader.readLine()) {
                    case "курицу":
                        if (chikenList.size() != 0) {
                            chikenList.removeLast();
                            System.out.println("Подаем курицу");
                        } else {
                            fishList.removeLast();
                            System.out.println("Молча протягиваем оставшийся набор");
                        }
                        break;
                    case "рыбу":
                        if (fishList.size() != 0) {
                            fishList.removeLast();
                            System.out.println("Подаем рыбу");
                        } else {
                            chikenList.removeLast();
                            System.out.println("Молча протягиваем оставшийся набор");
                        }
                        break;
                    default:
                        System.out.println("Такого набора у нас нет");
                        break;
                }
                System.out.println(chikenList);
                System.out.println(fishList);
                if (chikenList.size() == 0 && fishList.size() == 0) {
                    System.out.println("Возвращаемся в хвост самолета за пополнение запасов");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
