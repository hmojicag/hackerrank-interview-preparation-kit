package io.github.hmojicag.hackerrankinterviewkit.arrays;

import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class ArraysLeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        if (d == 0) {// No rotations to be performed
            return a;
        }
        // Use an auxiliar List
        Integer[] rotatedArray = new Integer[a.size()];
        for(int i = 0; i < a.size(); i++) {
            int v = a.get(i);
            int newIndex = calculateNewIndexNoIter(i, d, a.size());
            rotatedArray[newIndex] = v;
        }
        return Arrays.asList(rotatedArray);
    }

    private static int calculateNewIndex(int currentIndex, int nRotations, int arraySize) {
        // arraySize = 5, currentIndex = 0, nRotations = 2, newIndex = 3
        // arraySize = 5, currentIndex = 1, nRotations = 3, newIndex = 3
        // arraySize = 5, currentIndex = 3, nRotations = 2, newIndex = 1
        // arraySize = 5, currentIndex = 4, nRotations = 2, newIndex = 2
        int newIndex = currentIndex;
        for (int i = 0; i < nRotations; i++) {
            newIndex--;
            if (newIndex <= -1) {
                newIndex = arraySize-1;
            }
        }
        return newIndex;
    }

    private static int calculateNewIndexNoIter(int currentIndex, int nRotations, int arraySize) {
        // arraySize = 5, currentIndex = 0, nRotations = 2, newIndex = 3
        // arraySize = 5, currentIndex = 1, nRotations = 3, newIndex = 3
        // arraySize = 5, currentIndex = 3, nRotations = 2, newIndex = 1
        // arraySize = 5, currentIndex = 4, nRotations = 2, newIndex = 2
        int newIndex = currentIndex - nRotations;
        if (newIndex < 0) {
            newIndex = newIndex + arraySize;
        }
        return newIndex;
    }

}
