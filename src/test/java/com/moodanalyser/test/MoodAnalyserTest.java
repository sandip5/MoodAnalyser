package com.moodanalyser.test;

import com.moodanalyser.exception.MoodAnalyserException;
import com.moodanalyser.service.MoodAnalyser;
import com.moodanalyser.service.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", String.class);
        Assert.assertTrue(new MoodAnalyser("I am in happy mood").equals(moodAnalyser));
    }

    @Test
    public void givenClassName_WhenImproper_ShouldthrowMoodAnalysis() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", String.class);
        } catch (MoodAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenClassName_WhenConstructorNotProper_ShouldThrowMoodAnalysis() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", Integer.class);
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

    @Test
    public void givenHappyMood_WithReflection_ShouldReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", String.class);
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMood_WithReflection_WhenImproperMethod_ShouldReturnException() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyser("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", String.class);
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyseMooder");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
