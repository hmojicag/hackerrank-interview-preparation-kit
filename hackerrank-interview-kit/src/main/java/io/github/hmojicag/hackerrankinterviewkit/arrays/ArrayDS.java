package io.github.hmojicag.hackerrankinterviewkit.arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/arrays-ds/problem
public class ArrayDS {


    public static List<Integer> reverseArray(List<Integer> a) {
        // There are 2 different scenarios, but they are solved in the same way
        // [1,2,3,4]     Even number of elements
        // [1,2,3,4,5]   Odd number of elements
        // In any case the program should iterate to the half of the array.
        // To swap places with the corresponding index.

        // Example:
        // [1,2,3,4]     Even number of elements: 4. Iterate 4/2 = 2
        // [4,2,3,1]     Swap [0] and [3]
        // [4,3,2,1]     Swap [1] and [2]

        // Example:
        // [1,2,3,4,5]   Odd number of elements: 5. Iterate 5/2 = 2
        // [5,2,3,4,1]   Swap [0] and [4]
        // [5,4,3,2,1]   Swap [1] and [3]

        List<Integer> b = new ArrayList<>();
        b.addAll(a);// Copy the array, we don't want to affect the array passed in

        int numIters = b.size() / 2;
        int j = b.size() - 1;
        for (int i = 0; i < numIters; i++) {
            // Swap
            int temp = b.get(j);
            b.set(j, b.get(i));
            b.set(i, temp);
            j--;
        }
        return b;
    }



}
