package com.moodanalyser.exception;

public class MoodAnalyserException extends Exception {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FIELD, ILLEGAL_FIELD_ISSUE
    }

    public ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
