package com.company;

import java.util.Arrays;

public class For3 {
    public static void main(String[] args) {
        /*int n = 10, m = 2 * n - 1;
        int[][] arr = new int[n][m];
        arr[0][m/2]=1;
        for (int i = 1; i < n; i++) {
            int l = m / 2 - i, r = m / 2 + i;
            for(int j = l; j < r; j++){
                arr [i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }*/
        int rows=7, cols = 2*rows-1;
        int arr[][] = new int[rows][cols];
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++){
                if (i==0)
                    arr[0][cols/2] = 1;
                else if (j==0) arr[i][j] = arr[i-1][j+1];
                else if (j==cols-1) arr[i][j] = arr[i-1][j-1];
                else arr[i][j] = arr[i-1][j-1]+arr[i-1][j+1];
            }
        for (int i=0; i<rows; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}
