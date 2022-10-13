package com.company;

public class Funny1 {
    public static void main(String[] args) {
        /*long n = 1;
        for (int i = 0; i < 10; i++){
            String left = String.format("%d * %d = ", n, n);
            System.out.printf("%s%d%n", left, (long)n*n);
            n = n * 10 + 1;
        }*/

        char c = '5';
        String s = "";
        for (int i = 0; i < 15; i++){
            s+=c;
            String left = String.format("%s * %s = ", c, s);
            //System.out.printf("%20s%d%n", left, (long)Long.parseLong(s)*5);
            System.out.println(left+(long)Long.parseLong(s)*5);
        }
    }
}
