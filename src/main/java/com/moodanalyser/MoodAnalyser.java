package com.moodanalyser;

public class MoodAnalyser {
    String mood;
    public MoodAnalyser(String message){
        this.mood=message;
    }
    public String analyseMood() throws MoodAnalyserException {
        try {
            if (mood.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e){
            throw new MoodAnalyserException("Please Enter Valid Mood");
        }
    }
}
