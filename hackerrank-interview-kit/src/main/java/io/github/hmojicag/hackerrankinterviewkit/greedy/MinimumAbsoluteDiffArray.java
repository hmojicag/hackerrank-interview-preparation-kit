package io.github.hmojicag.hackerrankinterviewkit.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDiffArray {


    /**
     * [3,-7,0]
     * [-7,0,3] sorted
     *
     * [-4,-3,-2,-1,0,1,2,3,4]
     *
     * [-59 -36 -13 1 -53 -92 -2 -96 -54 75]
     * [-96 -92 -59 -54 -53 -36 -13 -2 1 75 ]
     *
     * The minimum difference is always the difference between 2 neighbouring numbers
     * in a sorted array.
     *
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // The minimum diff will be between the 2 numbers closest to 0
        List<Integer> arrSorted = new ArrayList<>(arr);
        java.util.Collections.sort(arrSorted);
        Integer minimumAbsoluteDiff = null;
        for(int i = 0; i < arrSorted.size()-1; i++) {
            int absDiff = Math.abs(arrSorted.get(i) - arrSorted.get(i+1));
            if (minimumAbsoluteDiff == null || absDiff < minimumAbsoluteDiff) {
                minimumAbsoluteDiff = absDiff;
                if (minimumAbsoluteDiff == 0) {
                    break;// We won't get better than this
                }
            }
        }
        return minimumAbsoluteDiff;
    }

    public static int minimumAbsoluteDifferenceDumb(List<Integer> arr) {
        Integer minimumAbsoluteDiff = null;
        for(int i = 0; i < arr.size(); i++) {
            for(int j = i+1; j < arr.size(); j++) {
                int absDiff = Math.abs(arr.get(i) - arr.get(j));
                if(minimumAbsoluteDiff == null || absDiff < minimumAbsoluteDiff) {
                    minimumAbsoluteDiff = absDiff;
                }
            }
        }
        return minimumAbsoluteDiff;
    }

}
