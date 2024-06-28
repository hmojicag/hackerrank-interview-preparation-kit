package io.github.hmojicag.hackerrankinterviewkit.arrays;


import java.util.LinkedList;
import java.util.List;

public class NewYearChaos {


    public static String minimumBribesImpl(List<Integer> q) {
        // THIS IMPLEMENTATION DIDN'T WORK

        // Here the ideal input list should always be ordered from 1 to size() all the time
        // Because it represents the natural order of the persons waiting in queue
        // To figure out if a person has bribed someone we just need to look at the position of that number
        // in the lis and how long has that person traveled in the list

        // Example:
        // [1 2 3 4 5]
        //      |---|
        //      d(5)    distance of 5 = 2
        //  |-|
        //   d(2)       distance of 2 = 1
        // [2 1 5 3 4]
        // - if (p>i) We consider a bribe took place only if a greater number moved to a lower index position
        // [1 2 3 4 5]
        //  1 0 2 0 0  sum = 3


        // Example:
        // [1,2,3,4,5]
        //    |-----|
        //      d(5)    distance of 5 = 3, Too Chaotic
        //  |-|
        //   d(2)       distance of 2 = 1
        // [2 5 1 3 4]
        // - if (p>i) We consider a bribe took place only if a greater number moved to a lower index position
        // [1,2,3,4,5]
        //  1 3 0 0 0   sum = 4


        // Example:
        // [1 2 3 4 5 6 7 8]
        //              |-|
        //              d(8)   distance of 8 = 1
        //      |---|
        //       d(5)   distance of 5 = 2
        //
        //            |-|
        //            d(7)   distance of 7 = 1
        //
        // [1 2 5 3 4 7 8 6]
        // - if (p>i) We consider a bribe took place only if a greater number moved to a lower index position
        // [1 2 3 4 5 6 7 8]
        //  0 0 2 0 0 1 1 0    sum = 4

        // [1 2 5 3 7 8 6 4]
        // [1 2 3 4 5 6 7 8]
        //  0 0 2 0 2 2 0 0

        int bribes = 0;
        for (int i = q.size(); i > 0; i--) {
            int p = q.get(i - 1);
            if (p > i) {// A bribe took place
                int bribe = p - i;
                if (bribe > 2) {
                    return "Too chaotic";
                }
                bribes += bribe;
            }
        }
        return Integer.toString(bribes);
    }

    public static String minimumBribesImpl2(List<Integer> qFinal) {
        // [1 2 3 4 5 6 7 8]
        //      |-2-|
        // [1 2 5 3 4 6 7 8]
        //          |-2-|
        // [1 2 5 3 7 4 6 8]
        //            |-2-|
        // [1 2 5 3 7 8 4 6]
        //              |1|
        // [1 2 5 3 7 8 6 4]

        int[] q = buildQ(qFinal.size());// q used to be a LinkedList, but it was too slow to get elements out of it
        int bribes = 0;
        for(int i = 0; i < q.length; i++) {
            int p = qFinal.get(i);
            int pR = q[i];
            if (p > (pR)) {// A bribe took place
                //int indexOfPInQ = q.indexOf(p);
                //int indexOfPInQ = searchIndexOfPInQ(q, i, p);
                //int bribe = indexOfPInQ - i;
                int bribe = getBribes(q, i, p);
                if (bribe > 2) {
                    return "Too chaotic";
                }
                bribes += bribe;
                doBribe(q, i+bribe, bribe);
            }
        }
        return Integer.toString(bribes);
    }

    // At the end the implementation was done in a simple array because:
    // * A LinkedList is too slow to get elements at random indexes
    // * An ArrayList is too slow at removing and deleting elements at random indexes
    private static void doBribe(int[] q, int startIndex, int bribes) {
        for(int i = 0; i < bribes; i++) {
            swap(q, startIndex, startIndex-1);
            startIndex--;
        }
    }

    // This was the old implementation
    // An ArrayList here would too slow because it had to shift all elements and then add again another element
    // A LinkedList would be more appropriate to remove and insert elements at random indexes
    private static void doBribeOld(List<Integer> q, int startIndex, int bribes) {
        int temp = q.remove(startIndex);
        int endIndex = startIndex - bribes;
        q.add(endIndex, temp);
    }

    // Swap array arr indexes
    private static void swap(int[] arr, int to, int from) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

    private static int[] buildQ(int n) {
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = i+1;
        }
        return q;
    }

    // This was old implementation of q using a LinkedList
    // This was not good since using q.get(x) is really slow because LinkedList iterate over the whole set for this
    private static List<Integer> buildQOld(int n) {
        List<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }
        return q;
    }

    private static int searchIndexOfPInQ(List<Integer> q, int startIndex, int p) {
        for(int i = startIndex; i < q.size(); i++) {
            if (q.get(i) == p) {
                return i;
            }
        }
        return -1;
    }

    private static int getBribes(int[] q, int startIndex, int p) {
        // Only search the next 2
        if (q[startIndex + 1] == p) {
            return 1;
        }
        if (q[startIndex + 2] == p) {
            return 2;
        }
        // Return 3 to mark it as "Too chaotic"
        return 3;
    }

}
