package io.github.hmojicag.hackerrankinterviewkit.arrays;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinimumSwaps2 {


    // 4 3 1 2
    // You are given an unordered array consisting of consecutive integers
    // [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements.
    // Find the minimum number of swaps required to sort the array in ascending order.

    public static int minimumSwaps(int[] arr) {
        // Remove this System.out.format before Running in HackerRank or you will get failed Test Cases due to Performance
        System.out.format("We start with array: %s \n", Arrays.toString(arr));

        // 1 Find the smallest number, since its position will always be at index 0
        // 2 Find the largest  number, since its position will always be at index length-1
        Integer smallest = null;
        Integer largest = null;
        for (int i = 0; i < arr.length; i++) {
            if (smallest == null || arr[i] < smallest) {
                smallest = arr[i];
            }
            if (largest == null || arr[i] > largest) {
                largest = arr[i];
            }
        }

        // 3 Move smallest number to index 0
        int swaps = 0;
        int expected = smallest;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != expected) {
                // If this index is NOT the value we expect then do a swap
                // of the value we expect to be in this index
                // this is only possible because we know the array should start in the smallest number
                // and all numbers are consecutive with no duplicates.
                int indexOfExpected = getIndexofValue(arr, i, expected);
                swap(arr, i, indexOfExpected);
                swaps++;
                // Remove this System.out.format before Running in HackerRank or you will get failed Test Cases due to Performance
                System.out.format("After swaping (%d,%d) we get array: %s. Swaps: %d \n", i, indexOfExpected, Arrays.toString(arr), swaps);
            }
            // Next expected is just +1 since all numbers are consecutive
            expected++;
        }
        return swaps;
    }

    // Swap array arr indexes
    private static void swap(int[] arr, int to, int from) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

    //
    private static int getIndexofValue(int[] arr, int startFrom, int value) {
        for (int i = startFrom; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


}
