package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(Constructor<?> message, String s) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalyserException {
        Class<?> moodAnalyserClass;
        try {
            moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }
    public static MoodAnalyser createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor, String s) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (MoodAnalyser) moodAnalyserConstructor.newInstance();
    }
}