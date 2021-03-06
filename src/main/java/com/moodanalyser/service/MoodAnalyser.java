package com.moodanalyser.service;

import com.moodanalyser.exception.MoodAnalyserException;
import java.util.Objects;

public class MoodAnalyser {
    static String mood;

    public MoodAnalyser() {

    }

    public MoodAnalyser(String message) {
        this.mood = message;
    }

    /**
     * Method For Analyse Mood
     *
     * @throws MoodAnalyserException
     */
    public String analyseMood() throws MoodAnalyserException {
        try {
            if (mood.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, "Please Enter Valid Mood");
            if (mood.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL, "Please Enter Valid Mood");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(mood, that.mood);
    }
}
