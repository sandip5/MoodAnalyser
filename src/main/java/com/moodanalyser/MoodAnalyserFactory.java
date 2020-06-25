package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static com.moodanalyser.MoodAnalyser.mood;

public class MoodAnalyserFactory {
    private Class<?> constructorObject;
    private String mood;
    private String className;


    public MoodAnalyserFactory(String className, String mood, Class<?> constructorObject){
        this.className=className;
        this.mood=mood;
        this.constructorObject=constructorObject;
    }
    public static MoodAnalyser createMoodAnalyser(String className, String mood, Class<?> constructorObject) throws MoodAnalyserException  {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(constructorObject);
            Object moodObj = moodConstructor.newInstance(mood);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,"No Class Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,"No Method Found");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}