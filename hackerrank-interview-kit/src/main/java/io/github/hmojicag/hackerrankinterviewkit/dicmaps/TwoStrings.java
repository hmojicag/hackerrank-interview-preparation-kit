package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        Map<Character, Integer> s1Map = stringToMap(s1);
        Map<Character, Integer> s2Map = stringToMap(s2);
        for(Map.Entry<Character, Integer> c : s1Map.entrySet()) {
            if(s2Map.containsKey(c.getKey())) {
                return "YES";
            }
        }
        return "NO";
    }

    /**
     * Transforms a string into a map where the key is a Char representing an individual character in that String
     * and the value is the number of repetitions for that char
     */
    private static Map<Character, Integer> stringToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }
        return map;
    }
}
