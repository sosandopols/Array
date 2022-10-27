package com.company;

import java.util.Random;

public class WordsCount {
    public static void main(String[] args) {
        String[] arr = {"It  is", "hello, world", "main  method in the class"};
        String s = "It  is, hello, world, main  method in the class";
        String[] result = s.split("[, ]+");
        for(String str : result)
            System.out.print(str + " ");
        System.out.println(result.length);
        int count = 0;
        for (int i=0; i<arr.length; i++){
            String[] temp = arr[i].split("[ ]+");
            count+=temp.length;
        }
        System.out.println(count);
        Random random = new Random();
    }
}
