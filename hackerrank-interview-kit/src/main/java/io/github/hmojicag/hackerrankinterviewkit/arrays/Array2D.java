package io.github.hmojicag.hackerrankinterviewkit.arrays;

import java.util.List;

// https://www.hackerrank.com/challenges/2d-array/problem
public class Array2D {
    public static int hourglassSum(List<List<Integer>> arr) {
        // Assumes arr is always 6x6
        Integer g = null;
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                int newG = getHourGlassSumAt(arr, i, j);
                if (g == null || newG > g) {
                    g = newG;
                }
            }
        }
        return g;
    }


    // Gets the hourglass starting at a certaing index
    // The hourglass starting inddex will always be the top most left value
    // Example:
    // a b c
    //   d
    // e f g
    // The index of 'a' will be provided
    // i is the value of the row
    // j is the value of the column
    private static int getHourGlassSumAt(List<List<Integer>> arr, int i, int j) {
        List<Integer> topRow = arr.get(i);
        List<Integer> middleRow = arr.get(i+1);
        List<Integer> bottomRow = arr.get(i+2);
        // The HourGlass always has the same shape.
        // Therefore I see no reason to iterate and overcomplicate the problem
        // I'll just harcode the specific items
        int a = topRow.get(j);
        int b = topRow.get(j+1);
        int c = topRow.get(j+2);
        int d = middleRow.get(j+1);
        int e = bottomRow.get(j);
        int f = bottomRow.get(j+1);
        int g = bottomRow.get(j+2);
        return a + b + c + d + e + f + g;
    }


}
