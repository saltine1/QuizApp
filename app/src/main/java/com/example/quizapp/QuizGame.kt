package com.example.quizapp

import android.widget.Button
import android.widget.TextView

class QuizGame(val questions: List<Question>) {
    // variables to track score, current question
    var score = 0
    var currentQuestion = 0
    var answerList = intArrayOf(2, 3, 1, 4, 3, 1, 1, 3, 3, 2, 4, 4, 1, 2, 4)
    // functions

    fun optChosen(num: Int){
        checkIfCorrect(num)
        nextQuestion()
    }
    private fun checkIfCorrect(chosenAnswer: Int) {
        if(chosenAnswer == answerList[currentQuestion]) {
            score++
        }
    }

    private fun nextQuestion(){
        currentQuestion++
    }

    fun loadQuestion(q: TextView, o1: Button, o2: Button, o3: Button, o4:Button){
            q.setText(questions[currentQuestion].question)
            o1.setText(questions[currentQuestion].option1)
            o2.setText(questions[currentQuestion].option2)
            o3.setText(questions[currentQuestion].option3)
            o4.setText(questions[currentQuestion].option4)
    }

    fun updateScore(t: TextView){
        t.text = "Score: $score"
    }

    // are there more questions?
    // getting the current question
    // checking answer
    // optional: reset the quiz, shuffle questions
}