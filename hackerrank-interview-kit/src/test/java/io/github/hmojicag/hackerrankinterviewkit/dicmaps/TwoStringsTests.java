package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import org.junit.Assert;
import org.junit.Test;

public class TwoStringsTests {

    @Test
    public void twoStringsTest0() {
        String result = TwoStrings.twoStrings("hello", "world");
        Assert.assertEquals("YES", result);
    }

    @Test
    public void twoStringsTest1() {
        String result = TwoStrings.twoStrings("hi", "world");
        Assert.assertEquals("NO", result);
    }

}
