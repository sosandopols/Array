package com.company;

public class Task7 {
    public static void main(String[] args) {
        int i = 123;
        while (i > 0) {
            int mod = i % 2;
            i /= 2;
            System.out.print(mod);
        }
    }
}
