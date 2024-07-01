package io.github.hmojicag.hackerrankinterviewkit.dicmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RansomNoteTests {

    @Test
    public void checkMagazineTest0() {
        java.util.List<String> magazine = Arrays.asList("give", "me", "one", "grand", "today", "night");
        List<String> note = Arrays.asList("give", "one", "grand", "today");
        String result = RansomNote.checkMagazineImpl(magazine, note);
        Assert.assertEquals("Yes", result);
    }

    @Test
    public void checkMagazineTest1() {
        java.util.List<String> magazine = Arrays.asList("two", "times", "three", "is", "not", "four");
        List<String> note = Arrays.asList("two", "times", "two", "is", "four");
        String result = RansomNote.checkMagazineImpl(magazine, note);
        Assert.assertEquals("No", result);
    }

    @Test
    public void checkMagazineTest2() {
        java.util.List<String> magazine = Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts");
        List<String> note = Arrays.asList("ive", "got", "some", "coconuts");
        String result = RansomNote.checkMagazineImpl(magazine, note);
        Assert.assertEquals("No", result);
    }


}
