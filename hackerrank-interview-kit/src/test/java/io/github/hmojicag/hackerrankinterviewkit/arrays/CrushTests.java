package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrushTests {

    @Test
    public void arrayManipulationTest4() throws IOException {
        CrushTestInputData crushTestInputData = getTestFromInputFile("src/test/resources/arrays/arrayManipulationTest4.txt");
        long expectedOutput = 7542539201l;
        long actualOutput = Crush.arrayManipulationVariant3(crushTestInputData.n, crushTestInputData.queries);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    private static CrushTestInputData getTestFromInputFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String[] nm = lines.get(0).split(" ");
        int n = Integer.parseInt(nm[0]);
        List<List<Integer>> queries = new ArrayList<>();
        for(int j = 1; j < lines.size(); j++) {
            String[] dStr = lines.get(j).split(" ");
            int a = Integer.parseInt(dStr[0]);
            int b = Integer.parseInt(dStr[1]);
            int k = Integer.parseInt(dStr[2]);
            queries.add(Arrays.asList(a,b,k));
        }
        return new CrushTestInputData(n, queries);
    }

    static class CrushTestInputData{
        int n;
        List<List<Integer>> queries;
        public CrushTestInputData(int n, List<List<Integer>> queries) {
            this.n = n;
            this.queries = queries;
        }
    }
}
