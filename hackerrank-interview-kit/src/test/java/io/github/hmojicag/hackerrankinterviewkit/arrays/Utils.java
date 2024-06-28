package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Assert;

import java.util.List;

public class Utils {
    public static void assertList(List<Integer> expected, List<Integer> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }
}
