package com.moodanalyser;

public class MoodAnalyser {
    String mood;
    public MoodAnalyser(String message){
        this.mood=message;
    }
    public String analyseMood() {
        if(mood.contains("sad"))
            return "SAD";
        else if(mood.contains("happy"))
            return "HAPPY";
        return null;
    }
}
