package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Контрольная работа:
        1. Вывести паттерн в виде треугольника заданной высоты:
        *
        *  *
        *    *
        ********
        2. Номиналы белорусских монет: 1,2,5,10,20,50.
        Дана сумма сдачи: 51..99 копеек.
        Выдать сдачу минимальным количеством монет.
*/
public class Okr2 {
    public static void main(String[] args) {
        int n = 4;
        String[] strings = new String[n * 2 - 1];
        for(int j = 0; j < n * 2 - 1; j++){
            strings[j] = " ";
            if (j == n - 1)
                strings[n - 1] = "*";
            System.out.print(strings[j]);
        }
        System.out.println();
        for(int j = 0; j < n * 2 - 1; j++){
            strings[j] = " ";
            if (j == n - 2)
                strings[n - 2] = "*";
            if (j == n)
                strings[n] = "*";
            System.out.print(strings[j]);
        }
        System.out.println();
        for (int i = 2; i < n - 1; i++){
            for(int j = 0; j < n * 2 - 1; j++){
                if (strings[j] == "*") {
                    strings[j - 1] = "*";
                    strings[j] = " ";
                }
                if (strings[j] == "*") {
                    strings[j + 1] = "*";
                    strings[j] = " ";
                }
            }
            for(int j = 0; j < n * 2 - 1; j++){
                System.out.print(strings[j]);
            }
            System.out.println();
        }
        for(int j = 0; j < n * 2 - 1; j++){
            strings[j] = "*";
            System.out.print(strings[j]);
        }
    }
}
