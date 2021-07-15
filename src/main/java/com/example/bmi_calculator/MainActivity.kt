package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText:EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        //같은 의미이다
        val resultButton=findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener{
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            if(heightEditText.text.isEmpty()||weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener //함수 빠져나오기 (뒤에 구문 실행되지 않음)
            }

            // 이 아래로는 절대 빈 값이 들어올 수 없다
            val height:Int=heightEditText.text.toString().toInt()
            val weight:Int=weightEditText.text.toString().toInt()
            Log.d("MainActivity", "height : $height weight : $weight")

            //ResultActivity 가 다음으로 실행된다
            val intent= Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height) // 값 넘기기
            intent.putExtra("weight", weight) // 값 넘기기
            startActivity(intent)
        }
    }
}