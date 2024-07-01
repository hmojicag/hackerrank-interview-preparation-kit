package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class RansomNote {

    /**
     * Given the words in the magazine and the words in the ransom note,
     * return Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, return No.
     */
    public static String checkMagazineImpl(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWords = listToMap(magazine);
        Map<String, Integer> noteWords = listToMap(note);
        for(Map.Entry<String, Integer> word : noteWords.entrySet()) {
            if(magazineWords.containsKey(word.getKey())) {
                int repetitions = magazineWords.get(word.getKey());
                if(repetitions < word.getValue()) {
                    return "No";
                }
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    /**
     * Transform a list of Strings to a Map where the hey is the word, Case Sensitive
     * and the value is the number of times that word appears in the List
     */
    private static Map<String, Integer> listToMap(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

}
