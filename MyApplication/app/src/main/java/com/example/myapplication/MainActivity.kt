package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        varTest()
        stringTest()
        loopTest()
        listTest()
        arrayTest()
        lambdaTest()

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

    fun varTest(){

        var a:Int  = 123
        var b = 0x1234_5678// アンダーバー可
        var c = 1234L

    }
    fun stringTest(){
        //val fncName = object{}.javaClass.enclosingMethod.name
        //printlen("$fncName")

        var a = "abc"// 変数
        val b = "xyz"// 定数

        a +=b
        println(a)//
    }

    fun  loopTest(){

        // ループ
        for (i in 99 downTo 0) println(i) // for (int i = 99; i >= 0; i--)
        for (i in 0 until 100 step 2) println(i) // for (int i = 0; i < 100; i += 2)
        for (i in 1..100) println(i) // for (int i = 1; i <= 100; i++)
    }

    fun listTest() {
        val a: List<Int> = listOf(2, 3, 5)

        //a.add はListにはない

        val b: MutableList<Int> = mutableListOf()
        b.add(2)
        b.add(3)
        b.add(5)
    }

    fun arrayTest(){
        val a = intArrayOf(2, 3, 5)
    }

    fun lambdaTest(){
        //val squared = numbers.map({ x -> x * x })
        val sum = { x: Int, y: Int -> x + y }
    }

    fun Test(){
      //  try {
      //      file.bufferedReader().use {
//
      //      }
      //  } catch (e: IOException) {
//
      //  }
    }
}