package com.moodanalyser;

public class MoodAnalyser {
    String mood;
    public MoodAnalyser(String message){
        this.mood=message;
    }
    /**
     * Method For Analyse Mood
     * @return
     * @throws MoodAnalyserException
     */
    public String analyseMood() throws MoodAnalyserException {
        try {
            if(mood.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Please Enter Valid Mood");
            if (mood.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Please Enter Valid Mood");
        }
    }
}
