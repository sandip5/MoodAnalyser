package com.moodanalyser.service;

import com.moodanalyser.exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyser(String className, String mood, Class<?> constructorObject) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(constructorObject);
            Object moodObj = moodConstructor.newInstance(mood);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "No Class Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "No Method Found");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalyserException {
        try {
           return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "Method Wrong");
        }

    }
}