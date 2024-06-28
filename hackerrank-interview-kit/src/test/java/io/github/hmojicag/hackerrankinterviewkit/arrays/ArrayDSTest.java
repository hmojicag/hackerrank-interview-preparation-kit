package io.github.hmojicag.hackerrankinterviewkit.arrays;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static io.github.hmojicag.hackerrankinterviewkit.arrays.Utils.assertList;

public class ArrayDSTest {

    @Test
    public void reverseArrayTest() {
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = ArrayDS.reverseArray(a);
        List<Integer> expected = Arrays.asList(3,2,1);
        assertList(expected,b);
    }

}
