package com.example.quizapp

class QuizGame(val questions: List<Question>) {
    // variables to track score, current question
    var score = 0
    var currentQuestion = 1
    var answerList = intArrayOf(2, 3, 1, 4, 3, 1, 1, 3, 3, 2, 4, 4, 1, 2, 4)
    // functions

    fun isCorrect(chosenAnswer: String) {
        if(chosenAnswer.substring(6,7) == (answerList[currentQuestion-1] as String)) {
            score++
        }
    }

    fun loadQuestion(){

    }


    // are there more questions?
    // getting the current question
    // checking answer
    // optional: reset the quiz, shuffle questions
}