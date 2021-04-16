package com.e.anzanrecord

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)
        number1Text.text = randomNumber1.toString()
        number2Text.text = randomNumber2.toString()

        val randomOperator = Random.nextInt(2)
        var operatorText = ""
        var correctAnswer = 0

        if (randomOperator == 0) {
            operatorText = "+"
            signText.text = operatorText
            correctAnswer = randomNumber1 + randomNumber2
        } else {
            operatorText = "-"
            signText.text = operatorText
            correctAnswer = randomNumber1 - randomNumber2
        }

        checkButton.setOnClickListener {
            val yourAnswer = inputText.text.toString()

            if(yourAnswer.isNotEmpty()){
               val answerPage = Intent(this, AnswerActivity::class.java)
                val questionText = randomNumber1.toString() + operatorText + randomNumber2.toString()
            }
        }
        operatorTextView.text = operator

        number1Text.text = number.toString()
        number2Text.text = number1.toString()


        val enterAnswer = answerTextView.editableText.toString()
        val answer = findViewById(R.id.answerTextView) as EditText
        val intEnterAnswer = enterAnswer.toIntOrNull()
//        val answer = findViewById<EditText>(R.id.answerTextView)


        var cpuAnswer = number + number1
        val cpu = cpuAnswer.toString()

        checkButton.setOnClickListener {
            if (enterAnswer == cpu) {

                val intent = Intent(this, RightAnswer::class.java)
                intent.putExtra("OPERATOR", operator)
                intent.putExtra("NUMBER", number)
                intent.putExtra("NUMBER1", number1)
                intent.putExtra("ENTER", enterAnswer)

                startActivity(intent)

            } else {
                val intent1 = Intent(this, WrongAnswer::class.java)
                intent1.putExtra("OPERATOR", operator)
                intent1.putExtra("NUMBER", number)
                intent1.putExtra("NUMBER1", number1)
                intent1.putExtra("ENTER", enterAnswer)

                startActivity(intent1)
            }


        }
    }
}
