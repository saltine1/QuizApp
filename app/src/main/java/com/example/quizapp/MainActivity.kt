package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load questions from JSON
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonString = inputStream.bufferedReader().use{
            it.readText()
        }
        Log.d(TAG, "onCreate: jsonString $jsonString")

        var quiz: QuizGame
        val gson = Gson()
        val qType = object: TypeToken<List<Question>>(){}.type
        val questions = gson.fromJson<List<Question>>(jsonString, qType)
        Log.d(TAG, "Questions: $questions")

        quiz = QuizGame(questions)
        // create Quiz object and pass in list of questions as a parameter
        // do the initial question and answer choices setup
        // set listeners to react to user input
        // passing info to and from the Quiz object
    }
}