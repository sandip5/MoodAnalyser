package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser;
    String result;
    String mood = "I am in a happy mood";
    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws MoodAnalyserException{
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in happy mood", String.class);
        try {
            String mood=moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ShouldthrowMoodAnalysis() {
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in happy mood", String.class);
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenClassName_WhenConstructorNotProper_ShouldThrowMoodAnalysis() {
        try {
            MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("com.moodanalyser.MoodAnalyser", "I am in happy mood", Integer.class);
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood.");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyserException ignored) {
        }
    }
    @Test
    public void givenMessage_WhenNotSad_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy mood");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException ignored) {
        }
    }
    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMood_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_NULL, e.type);
        }
    }
    @Test
    public void givenEmptyMood_ShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
}
