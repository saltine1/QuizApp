package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    lateinit var questionText: TextView
    lateinit var option1: Button
    lateinit var option2: Button
    lateinit var option3: Button
    lateinit var option4: Button
    lateinit var score: TextView
    companion object{
        val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wire()
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

        // do the initial question and answer choices setup
        questionText.setText(questions[0].question)
        option1.setText(questions[0].option1)
        option2.setText(questions[0].option2)
        option3.setText(questions[0].option3)
        option4.setText(questions[0].option4)


        // set listeners to react to user input
        option1.setOnClickListener {
            optionChosen(quiz,1)
        }
        option2.setOnClickListener {
            optionChosen(quiz,2)

        }
        option3.setOnClickListener {
            optionChosen(quiz,3)
        }
        option4.setOnClickListener{
            optionChosen(quiz,4)
        }
        // passing info to and from the Quiz object

    }

    fun optionChosen(q: QuizGame, n: Int){
        q.optChosen(n)
        q.loadQuestion(questionText,option1,option2,option3,option4)
        q.updateScore(score)
    }
    fun wire() {
        questionText = findViewById(R.id.textview_main_question)
        option1 = findViewById(R.id.button_main_option1)
        option2 = findViewById(R.id.button_main_option2)
        option3 = findViewById(R.id.button_main_option3)
        option4 = findViewById(R.id.button_main_option4)
        score = findViewById(R.id.textview_main_score)
    }
}
