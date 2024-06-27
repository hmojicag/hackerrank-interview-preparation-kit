package io.github.hmojicag.hackerrankinterviewkit.arrays;

import java.util.List;

// https://www.hackerrank.com/challenges/crush/problem
public class Crush {

    /**
     * Starting with a 1-indexed array of zeros and a list of operations,
     * for each operation add a value to each the array element between two given indices,
     * inclusive. Once all operations have been performed, return the maximum value in the array.
     * @param n
     * @param queries
     * @return
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Create the empty array, since is just integers the default value is 0
        long[] arr = new long[n];
        // Keep the value of the max number so that we don't have to iterate the array again
        Long max = null;
        for (List<Integer> query : queries) {
            int a = query.get(0)-1;    // Starting index base 1, to base 0
            int b = query.get(1)-1;    // Ending index base 1, to base 0
            int k = query.get(2);      // Value to add
            for (int i = a; i <= b; i++) {
                arr[i] += k;
                if (max == null || arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

    public static long arrayManipulationVariant1(int n, List<List<Integer>> queries) {
        // Create the empty array, since is just integers the default value is 0
        long[] arr = new long[n];
        // Keep the value of the max number so that we don't have to iterate the array again
        for (List<Integer> query : queries) {
            int a = query.get(0)-1;    // Starting index base 1, to base 0
            int b = query.get(1)-1;    // Ending index base 1, to base 0
            int k = query.get(2);      // Value to add
            for (int i = a; i <= b; i++) {
                arr[i] += k;
            }
        }
        long max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static long arrayManipulationVariant3(int n, List<List<Integer>> queries) {
        // Same array of zeros
        long[] arr = new long[n];
        // But we will only save the changes at certain indexes
        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        // I'll use a and b as index base 0 instead of the examples that come as base 1

        // Q1. a=0, b=4, k=3
        // [3, 0, 0, 0, 0, -3, 0, 0, 0, 0]
        // arr[a] = arr[a]+k
        // arr[b+1] = arr[b+1]-k
        // Now if we were to get the actual value of:
        // * arr[2] is 3 because if we sum from arr[0] to arr[2] we get 3
        // * arr[6] is 0 because if we sum from arr[0] to arr[6] we get 0

        // Q2. a=2, b=6, k=5
        // [3, 0, 5, 0, 0, -3, -5, 0, 0, 0]
        // arr[a] = arr[a]+k
        // arr[b+1] = arr[b+1]-k
        // Now if we were to get the actual value of:
        // * arr[2] is 8 because if we sum from arr[0] to arr[2] we get 8
        // * arr[6] is 0 because if we sum from arr[0] to arr[6] we get 0

        for (List<Integer> query : queries) {
            int a = query.get(0)-1;    // Starting index base 1, to base 0
            int b = query.get(1)-1;    // Ending index base 1, to base 0
            int k = query.get(2);      // Value to add
            arr[a] += k;
            if (b < (arr.length-1)) {
                arr[b+1] -= k;
            }
        }
        // Find the max value
        Long max = null;
        long cumulative = 0;
        for (int i = 0; i < arr.length; i++) {
            long valueForItem = cumulative + arr[i];
            if (max == null || valueForItem > max) {
                max = valueForItem;
            }
            cumulative = valueForItem;
        }
        return max;
    }
}
