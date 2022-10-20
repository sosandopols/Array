package com.company;

import java.util.Arrays;
import java.util.Random;

import static com.company.Sorting.swap;

public class QuickSort {
    public static int RUN = 32;
    static int size;
    static int[] arr;

    public static void main(String[] args) {
        size = 1_000_000;
        arr = new int[size];
        fillRandom();
        long start=System.nanoTime();
        //bubbleSort();
        //mergeSort(0, size - 1);
        // quickSort(0,size-1);
        Arrays.sort(arr);
        long end=System.nanoTime();
        double time=(end-start)*1e-9;
        System.out.println("bubble: "+time);
        // print();


        //timSort();
        //heapSort();
        //print();

    }

    static void print() {
        System.out.println(Arrays.toString(arr));
    }

    static void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < size; i++)
            arr[i] = random.nextInt(90) + 10;
    }

    static void bubbleSort() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
    }

    public static void mergeSort(int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
        print();
    }

    //Слияние внутри одного массива
    public static void merge(int l, int m, int r) {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int i = 0; i < len1; i++)
            left[i] = arr[l + i];
        for (int i = 0; i < len2; i++)
            right[i] = arr[m + 1 + i];
        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we
        // merge those two array
        // in larger sub array
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of left, if any
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copy remaining element of right, if any
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    //Timsort
    public static int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }

    public static void insertionSort(int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void timSort()
    {
        int n = arr.length;
        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i+=RUN)
            insertionSort(i, min((i+RUN-1),
                    (n-1)));

        // Start merging from size RUN (or 32).
        // It will merge
        // to form size 64, then 128, 256
        // and so on ....
        for (int size = RUN; size < n;
             size = 2*size)
        {

            // pick starting point of
            // left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n;
                 left += 2*size)
            {

                // find ending point of
                // left sub array
                // mid+1 is starting point
                // of right sub array
                int mid = left + size - 1;
                int right = min((left + 2*size - 1),
                        (n-1));

                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if(mid < right)
                    merge(left, mid, right);
            }
        }
    }
}