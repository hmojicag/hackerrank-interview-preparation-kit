package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MinimumSwaps2Tests {

    @Test
    public void minimumSwapsTest0() {
        int[] arr = new int[]{4, 3, 1, 2};
        int expectedMinimumSwaps = 3;
        int actualMinimumSwaps = MinimumSwaps2.minimumSwaps(arr);
        Assert.assertEquals(expectedMinimumSwaps, actualMinimumSwaps);
    }

    @Test
    public void minimumSwapsTest1() {
        int[] arr = new int[]{2, 3, 4, 1, 5};
        int expectedMinimumSwaps = 3;
        int actualMinimumSwaps = MinimumSwaps2.minimumSwaps(arr);
        Assert.assertEquals(expectedMinimumSwaps, actualMinimumSwaps);
    }

    @Test
    public void minimumSwapsTest2() {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6, 7};
        int expectedMinimumSwaps = 3;
        int actualMinimumSwaps = MinimumSwaps2.minimumSwaps(arr);
        Assert.assertEquals(expectedMinimumSwaps, actualMinimumSwaps);
    }

    @Test
    public void minimumSwapsTest8() throws IOException {
        StopWatch watch = new StopWatch();
        int[] arr = getTestFromInputFile("src/test/resources/arrays/MinimumSwaps2Test8.txt");
        int expectedMinimumSwaps = 9984;
        watch.start();
        int actualMinimumSwaps = MinimumSwaps2.minimumSwaps(arr);
        watch.stop();
        Assert.assertEquals(expectedMinimumSwaps, actualMinimumSwaps);
        long msEllapsed = watch.getTotalTimeMillis();
        System.out.format("minimumSwaps took: %d \n", msEllapsed);
    }


    private static int[] getTestFromInputFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String[] dStr = lines.get(1).split(" ");
        int[] d = new int[dStr.length];
        for (int i = 0; i < dStr.length; i++) {
            d[i] = Integer.parseInt(dStr[i]);
        }
        return d;
    }

}
