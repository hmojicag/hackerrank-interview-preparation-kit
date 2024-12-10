package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

/**
 * HackerRank.
 * Sherlock and Anagrams.
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 */
public class SherlockAndAnagrams {

    private static int r = 2;
    private static BigInteger factR = factorialHavingLargeResult(r);

    /**
     * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
     * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
     * @param s
     * @return
     */
    public static int sherlockAndAnagrams(String s) {
        return doStupidSherlockAndAnagrams(s);
    }

    /**
     * Builds a Map of substring for the provided String.
     * Only returns the number of Anagrams according to description of this problem.
     *
     * The goal here is to group the substrings first by length since only substrings of same length can be anagrams of each other.
     * And then group them by the hash value of the alphabetically sorted string which if it's the same value then they are anagrams
     * because they have the exact same letters.
     * Example:
     * Substrings: "abbc" and "cbab" are anagrams because they have the same letters.
     * If we sort them alphabetically we get "abbc" for both.
     * And using the hash value instead of string comparison works faster.
     *
     * The key of the first Map is the length of the SubString.
     * The value a secondary Map.
     * The secondary Map:
     *  * Key: The Hash value of the sorted substring
     *  * Value: A List of Substrings that have the same Hash value, therefore, anagrams of each other
     */
    private static int doStupidSherlockAndAnagrams(String s) {
        //  K:Length,          V: Map
        Map<Integer, Map<Integer, List<AnagramSubstring>>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                int length = substring.length();
                if (length == 0 || length == s.length()) {
                    continue;
                }

                //  K: Hash Sorted Substring
                //  V: List of Substrings for same hash
                Map<Integer, List<AnagramSubstring>> subMap;
                if (map.containsKey(length)) {
                    subMap = map.get(length);
                } else {
                    subMap = new HashMap<>();
                    map.put(length, subMap);
                }
                AnagramSubstring anagramSubstring = new AnagramSubstring(substring);
                List<AnagramSubstring> anagramSubstrings;
                if(subMap.containsKey(anagramSubstring.sortedHashValue)) {
                    anagramSubstrings = subMap.get(anagramSubstring.sortedHashValue);
                } else {
                    anagramSubstrings = new ArrayList<>();
                    subMap.put(anagramSubstring.sortedHashValue, anagramSubstrings);
                }
                anagramSubstrings.add(anagramSubstring);
            }
        }

        int anagrams = 0;// Iterate each set of anagrams found
        for(Map<Integer, List<AnagramSubstring>> subMap : map.values()) {
            for(List<AnagramSubstring> anagramSubstrings : subMap.values()) {
                if (anagramSubstrings.size() > 1) {
                    // Calculate the number of possible combinations for this set
                    /**
                     * C(n,r)=n!(r!(n-r)!)
                     * n (objects) is the list size
                     * r (sample) is always 2
                     */
                    int n = anagramSubstrings.size();
                    BigInteger factN = factorialHavingLargeResult(n);
                    BigInteger factNmR = factorialHavingLargeResult(n-r);
                    //long combinations = factN / (factR * factNmR);
                    BigInteger combinations = factN.divide(factR.multiply(factNmR));
                    anagrams += combinations.intValue();
                }
            }
        }

        return anagrams;
    }

    public static BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    static class AnagramSubstring {
        String substring;
        String sortedString;
        int sortedHashValue;
        AnagramSubstring(String substring) {
            this.substring = substring;
            char charArray[] = this.substring.toCharArray();
            Arrays.sort(charArray);
            sortedString = new String(charArray);
            sortedHashValue = sortedString.hashCode();
        }
        boolean isAnagramOf(AnagramSubstring anagramSubstring) {
            return sortedHashValue == anagramSubstring.sortedHashValue;
        }
    }

    // ALL THESE COMMENTS BELOW ARE USELESS NOW
    // Example:
    // abba

    // These are all the possible substrings
    // a
    // ab
    // abb
    // b
    // bb
    // bba
    // b
    // ba
    // a

    // These are all the substrings arranged in a map with the corresponding number of repetitions each
    // a   -> 2
    // ab  -> 1
    // abb -> 1
    // b   -> 2
    // bb  -> 1
    // bba -> 1
    // ba  -> 1

    // Now iterate through all the keys (substrings) and find the anagrams
    // Decrease the value of repetitions if that substring was already checked

    // Loop 1
    // Take a. Decrease by 1.
    // a   -> 1
    // Search for anagrams for a. Found in [0].
    // anagrams++
    // Decrease by 1.
    // a   -> 0
    // Remove a from Map since it reached 0.

    // ab  -> 1
    // abb -> 1
    // b   -> 2
    // bb  -> 1
    // bba -> 1
    // ba  -> 1

    // Loop 2
    // Take ab. Decrease by 1.
    // ab  -> 0
    // Remove ab from Map.
    // Search anagrams for ab. Found ba in [5]
    // anagrams++
    // Decrease ba 1.
    // Remove ba from Map

    // abb -> 1
    // b   -> 2
    // bb  -> 1
    // bba -> 1

    // Loop 3
    // Take abb. Decrease by 1. Remove abb from Map.
    // Search anagrams for abb. Found bba at [3].
    // angrams++
    // Decrease bba by 1. Remove bba from Map

    // b   -> 2
    // bb  -> 1

    // Loop 4
    // Same as a but for b
    // anagram++

    // bb  -> 1

    // Loop 5
    // Las element no anagrams to be found

}
