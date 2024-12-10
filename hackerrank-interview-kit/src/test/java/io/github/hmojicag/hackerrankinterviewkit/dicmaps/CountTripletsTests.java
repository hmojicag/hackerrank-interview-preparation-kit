package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CountTripletsTests {

    @Test
    public void countTripletsTestSample0() {
        List<Long> arr = Arrays.asList(1l,2l,2l,4l);
        assertCountTriplets(arr, 2, 2l);
    }

    @Test
    public void countTripletsTestSample1() {
        List<Long> arr = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
        assertCountTriplets(arr, 3, 6l);
    }

    @Test
    public void countTripletsTestSample2() {
        List<Long> arr = Arrays.asList(1l, 5l, 5l, 25l, 125l);
        assertCountTriplets(arr, 5, 4l);
    }

    @Test
    public void countTripletsTest2() {
        List<Long> arr = Arrays.asList(1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l);
        assertCountTriplets(arr, 1, 161700l);
    }

    private void assertCountTriplets(List<Long> arr, int r, long expectedResult) {
        long actualResult = CountTriplets.countTriplets(arr, r);
        Assert.assertEquals(expectedResult, actualResult);
    }

}
