package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 * You are given an array and you need to find number of triplets of indices (i,j,k) such that the elements at those indices
 * are in geometric progression for a given common ratio r and i<j<k.
 */
public class CountTriplets {


    static long countTriplets(List<Long> arr, long r) {
        return countTripletsImpl2(arr, r);
    }

    /**
     *  [ 1 2 2 4] r = 2
     *
     *  1
     *  doubles = [(2,1)]
     *  2
     *  doubles  = [(2,1),(4,1)]
     *  triplets = [(4,1)]
     *  2
     *  doubles  = [(2,1),(4,2)]
     *  triplets = [(4,2)]
     *  4
     *  doubles  = [(2,1),(4,2),(8,1)]
     *  triplets = [(4,2),(8,2)]
     *
     */

    static long countTripletsImpl2(List<Long> arr, long r) {
        //number of times we encounter key*r
        Map<Long, Long> doubles = new HashMap<>();
        //number of times we encounter a triplet
        Map<Long, Long> triplets = new HashMap<>();
        long count = 0;
        for (Long key : arr) {
            long keyXr = key * r;
            if (triplets.containsKey(key)) {
                count += triplets.get(key);
            }
            if (doubles.containsKey(key)) {
                if (triplets.containsKey(keyXr)) {
                    triplets.put(keyXr, triplets.get(keyXr) + doubles.get(key));
                } else {
                    triplets.put(keyXr, doubles.get(key));
                }
            }
            if (doubles.containsKey(keyXr)) {
                doubles.put(keyXr, doubles.get(keyXr) + 1);
            } else {
                doubles.put(keyXr, 1l);
            }
        }
        return count;
    }


    /**
     *   [ 1 2 2 4] r = 2
     *
     *       1
     *     |  \
     *     2   2
     *     |   |
     *    4    4
     *
     * [1 5 5 25 125] r = 5
     *
     *        1
     *      /  \
     *     5   5
     *     |   |
     *    25  25
     *    |   |
     *   125 125
     *
     * [1 4 16 64] r = 4
     *     1
     *   /  \
     *  4
     *  |
     *  16
     *  |
     *  64
     *
     *  [1 3 9 9 27 81] r = 3
     *     1
     *   /
     *   3
     *  | \
     *  9  9
     *  |  |
     * 27  27
     *  |  |
     * 81  81
     *
     *  [2 0 9 9 27 7 6 100 81 243 18] r = 3
     *       2     0     9    7    9    100
     *       |     |     |    |    |
     *      6           27        27
     *      |           |         |
     *     18          81        81
     *                 |         |
     *                243       243
     *
     * [1 1 1 1] r = 1
     *       1
     *    /  |  \
     *   1   1  1
     *   |   |
     *   1   1
     *   |
     *   1
     *
     * Length 1. Triplets = 0
     * Length 2. Triplets = 0
     * Length 3. Triplets = 1
     * Length 4. Triplets = 2
     * Length 5. Triplets = 3
     * Length 6. Triplets = 4
     * Length 7. Triplets = 5
     * Length 8. Triplets = 6
     * if (Length>2) Triplets = Length-2
     */

    static long countTripletsImpl(List<Long> arr, long r) {
        if(arr.size() < 3) {
            return 0;
        }
        List<Node> forest = new ArrayList<>();
        for(Long a : arr) {
            boolean added = false;
            for(Node node : forest) {
                if(node.addValue(a)) {
                    added = true;
                }
            }
            if(!added) {// Create a new root
                Node node = new Node(a, r);
                forest.add(node);
            }
        }

        // Traverse the forest and get the length for each path
        long triplets = 0;
        for(Node node : forest) {
            List<Long> branchesLengths = node.getBranchesLengths();
            for(Long branchLength : branchesLengths) {
                if(branchLength > 2) {
                    triplets += (branchLength-2);
                }
            }
        }
        return triplets;
    }

    static class Node {
        Long value;
        Long nextValue;
        List<Node> nodes = new ArrayList<>();
        long r;
        Node(Long value, long r) {
            this.value = value;
            this.nextValue = value * r;
            this.r = r;
        }
        boolean addValue(Long value) {
            boolean added = false;
            if (value % this.value == 0) {
                // New Value is multiple of this value, ok, proceed
                for(Node n : this.nodes) {
                    if(n.addValue(value)) {
                        added = true;
                    }
                }
                if (this.nextValue == value) {
                    this.nodes.add(new Node(value, this.r));
                    added = true;
                }
            }
            return added;
        }
        List<Long> getBranchesLengths() {
            List<Long> lengths = new ArrayList<>();
            if (nodes.isEmpty()) {
                lengths.add(1l);
                return lengths;
            } else {
                for(Node node : nodes) {
                    List<Long> branchesLengths = node.getBranchesLengths();
                    for(Long branchLength : branchesLengths) {
                        lengths.add(branchLength+1);
                    }
                }
            }
            return lengths;
        }
    }

}
