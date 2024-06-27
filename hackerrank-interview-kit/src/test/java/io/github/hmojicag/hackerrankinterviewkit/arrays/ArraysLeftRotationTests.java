package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysLeftRotationTests {

    @Test
    public void rotLeftTest0() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(5, 1, 2, 3, 4);
        List<Integer> rotated = ArraysLeftRotation.rotLeft(a, 4);
        assertList(expected, rotated);
    }

    @Test
    public void rotLeftTest1() {
        List<Integer> a = Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51);
        List<Integer> expected = Arrays.asList(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77);
        List<Integer> rotated = ArraysLeftRotation.rotLeft(a, 10);
        assertList(expected, rotated);
    }

    @Test
    public void rotLeftTest2() {
        List<Integer> a = Arrays.asList(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97);
        List<Integer> expected = Arrays.asList(87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100,   60);
        List<Integer> rotated = ArraysLeftRotation.rotLeft(a, 13);
        assertList(expected, rotated);
    }

    private static void assertList(List<Integer> expected, List<Integer> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
