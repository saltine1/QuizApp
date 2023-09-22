package com.example.quizapp

data class Question(var question: String, var option1: String, var option2: String,
    var option3: String, var option4: String)

data class Answer(var answer: Int)
