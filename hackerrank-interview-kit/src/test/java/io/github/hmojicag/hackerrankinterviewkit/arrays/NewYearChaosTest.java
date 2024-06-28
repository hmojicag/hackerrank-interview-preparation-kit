package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewYearChaosTest {

    @Test
    public void minimumBribesTest0_1() {
        List<Integer> q = Arrays.asList(2,1,5,3,4);
        String result = NewYearChaos.minimumBribesImpl2(q);
        Assert.assertEquals("3", result);
    }

    @Test
    public void minimumBribesTest0_2() {
        List<Integer> q = Arrays.asList(2,5,1,3,4);
        String result = NewYearChaos.minimumBribesImpl2(q);
        Assert.assertEquals("Too chaotic", result);
    }

    @Test
    public void minimumBribesTest1_1() {
        List<Integer> q = Arrays.asList(5,1,2,3,7,8,6,4);
        String result = NewYearChaos.minimumBribesImpl2(q);
        Assert.assertEquals("Too chaotic", result);
    }

    @Test
    public void minimumBribesTest1_2() {
        List<Integer> q = Arrays.asList(1,2,5,3,7,8,6,4);
        String result = NewYearChaos.minimumBribesImpl2(q);
        Assert.assertEquals("7", result);
    }

    @Test
    public void minimumBribesTest6() throws IOException {
        List<List<Integer>> tests = getTestFromInputFile("src/test/resources/arrays/NewYearChaosTest6.txt");
        minimumBribesTest(tests, 0, "96110");
        minimumBribesTest(tests, 1, "Too chaotic");
        minimumBribesTest(tests, 2, "Too chaotic");
        minimumBribesTest(tests, 3, "96319");
        minimumBribesTest(tests, 4, "96323");
        minimumBribesTest(tests, 5, "96058");
    }

    private static void minimumBribesTest(List<List<Integer>> tests, int testIndex, String expectedOutput) {
        List<Integer> data = tests.get(testIndex);
        String result = NewYearChaos.minimumBribesImpl2(data);
        Assert.assertEquals(expectedOutput, result);
    }

    private static List<List<Integer>> getTestFromInputFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<List<Integer>> data = new ArrayList<>();
        int t = Integer.parseInt(lines.get(0).trim());
        int indexOfData = 2;
        for (int i = 0; i < t; i++) {
            String[] dStr = lines.get(indexOfData).split(" ");
            List<Integer> testSet = new ArrayList<>();
            for (int j = 0; j < dStr.length; j++) {
                testSet.add(Integer.parseInt(dStr[j].trim()));
            }
            data.add(testSet);
            indexOfData += 2;
        }
        return data;
    }

}
