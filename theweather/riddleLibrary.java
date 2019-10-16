package com.example.tanzi.theweather;

public class riddleLibrary {
    private String mQuestions [] = {
            "What is it that lives if it is fed, and dies if you give it a drink",
            "What can be broken, but is never held",
            "If you have a bowl with six apples and you take away four, how many do you have?",
            "How did the boy kick his soccer ball ten feet, and then have it come back to him on its own?",
            "What has a head, a tail, but does not have a body?",
            "What is the maximum number of times a single page of a newspaper can be folded in half by hand?",
            "Why can not a woman living in the Europe be buried in Canada?",
            "What is white and black, but red all over?",
            "Where is an ocean with no water?",
            "Which room has no walls?"

    };


    private String mCorrectAnswers[] = {"Fire", "A promise", "The 4 you took away", "He kicked it up!","A coin","Only once",
            "A living woman cannot be buried anywhere.","The newspaper is “read” all over.","On a map","A mushroom"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }




    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
