package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textMessage = findViewById<TextView>(R.id.message_text)

        var buttonCat = findViewById<Button>(R.id.cat_button)
        var buttonDog = findViewById<Button>(R.id.dog_button)

        // 以下、ボタン押下でメッセージ更新
        buttonCat.setOnClickListener{
            textMessage.setText(R.string.cat_text_message)
        }

        buttonDog.setOnClickListener {
            textMessage.setText(R.string.dog_text_message)
        }
    }
}