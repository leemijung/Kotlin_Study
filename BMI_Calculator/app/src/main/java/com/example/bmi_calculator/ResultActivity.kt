package com.example.bmi_calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityresult)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        // 자바, getIntent 사용용

        val BMI=weight / (height / 100.0).pow(2.0) // double로 표현
        val resultText=when{
            BMI>=35.0 ->"고도 비만"
            BMI>=30.0 ->"중정도 비만"
            BMI>=25.0 ->"경도 비만"
            BMI>=23.0 ->"과체중"
            BMI>=18.0 ->"정상체중"
            else ->"저체중"
        }

        val resultValueTextView=findViewById<TextView>(R.id.bmiResult)
        val resultStringTestView=findViewById<TextView>(R.id.resultText)

        resultValueTextView.text=BMI.toString()
        resultStringTestView.text=resultText
    }
}
