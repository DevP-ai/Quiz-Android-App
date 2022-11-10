package com.dev.android.quiz;

public class QuestionAnswer {

    public static  String question[]={
            "What is the use of final keyword in Java?",
            "Which of the following is FALSE about arrays on Java ?",
            " When an expression consists of int, double, long, float, then the entire expression will get promoted into a data type that is:",
            "What is it called when the child object also gets killed when the parent object is killed in the program?",
            "Out of these methods of the String class, which one can be used for testing the strings for equality?"
    };

    public static  String choices[][]={
            {"When a class is made final, a subclass of it can not be created","When a method is final, it can not be overridden","When a variable is final, it can be assigned value only once","All of the above"},
            {"A java array is always an object","Length of array can be changed after creation of array","Arrays in Java are always allocated on heap","All of the above"},
            {"float","double", "int", "long"},
            {"Encapsulation", "Association", "Aggregation", "Composition"},
            {"isequals()","isequal()","equals()","equal()"}
    };

    public static String correctAnswer[]={
            "All of the above",
            "Length of array can be changed after creation of array",
            "double",
            "Composition",
            "equals()"
    };
}
