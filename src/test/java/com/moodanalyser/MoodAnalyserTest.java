package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood.");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenMessage_WhenNotSad_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy mood");
        try{
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood =moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try{
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood =moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
}
