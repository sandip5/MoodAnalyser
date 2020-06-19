package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood.");
        String mood =moodAnalyser.analyseMood();
        Assert.assertEquals( "SAD",mood);
    }
    @Test
    public void givenMessage_WhenNotSad_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        String mood =moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
