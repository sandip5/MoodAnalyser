package com.moodanalyser;

public class MoodAnalyser {
    String mood;
    public MoodAnalyser(String message){
        this.mood=message;
    }
    public String analyseMood() {
        if(mood.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
