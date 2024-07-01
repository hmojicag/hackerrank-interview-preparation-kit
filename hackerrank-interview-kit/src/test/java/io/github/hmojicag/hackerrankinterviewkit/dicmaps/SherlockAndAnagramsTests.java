package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import org.junit.Assert;
import org.junit.Test;

public class SherlockAndAnagramsTests {

    @Test
    public void sherlockAndAnagramsTest0_1() {
        assertAnagrams("abba", 4);
    }

    @Test
    public void sherlockAndAnagramsTest0_2() {
        assertAnagrams("abcd", 0);
    }

    @Test
    public void sherlockAndAnagramsTest1_1() {
        assertAnagrams("ifailuhkqq", 3);
    }

    @Test
    public void sherlockAndAnagramsTest1_2() {
        assertAnagrams("kkkk", 10);
    }

    @Test
    public void sherlockAndAnagramsTest2() {
        assertAnagrams("cdcd", 5);
    }

    @Test
    public void sherlockAndAnagramsTest3_1() {
        assertAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650);
    }

    @Test
    public void sherlockAndAnagramsTest3_2() {
        assertAnagrams("bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa", 4832);
    }

    @Test
    public void sherlockAndAnagramsTest3_4() {
        assertAnagrams("cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba", 13022);
    }

    private void assertAnagrams(String s, int expectedAnagrams) {
        int actualAnagrams = SherlockAndAnagrams.sherlockAndAnagrams(s);
        Assert.assertEquals(expectedAnagrams, actualAnagrams);
    }

}
