package io.github.hmojicag.hackerrankinterviewkit.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDiffArrayTests {

    @Test
    public void minimumAbsoluteDifferenceTest0(){
        List<Integer> arr = Arrays.asList(3, -7, 0);
        assertMinimumAbsoluteDifference(arr, 3);
    }

    private void assertMinimumAbsoluteDifference(List<Integer> arr, int expectedOutput) {
        int actualOutput = MinimumAbsoluteDiffArray.minimumAbsoluteDifference(arr);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

}
