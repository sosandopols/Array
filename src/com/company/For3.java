package com.company;

import java.util.Arrays;

public class For3 {
    public static void main(String[] args) {
        int n = 17, m = 2 * n - 1, l = m / 2, r = (m + 1) / 2;
        int[][] arr = new int[n][m];
        arr[0][m / 2] = 1;
        for (int i = 1; i < n; i++) {
            l--;
            r++;
            for (int j = l; j < r; j++) {
                if (j == 0) arr[i][j] = arr[i - 1][j + 1];
                else if (j == m - 1) arr[i][j] = arr[i - 1][j - 1];
                else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(arr[i]));
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                String s = Integer.toString(arr[i][j]);
                String pad = String.format("%5s",s);
                if(arr[i][j] != 0)
                    System.out.print(pad);
                else
                    System.out.print("     ");
            }
            System.out.println();
        }
    }
}
