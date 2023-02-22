package com.example.jetpacktest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacktest.ui.theme.JetpackTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {

    Column{

        Text("Hello")
        Text(text = "Hello", color = Color.Red)
        Text(text = "Hello", color = Color.Blue)
        Text(text = "Hello", color = Color(0xff77ddbb))

        Text(text = "Hello", fontSize = 10.sp)
        Text(text = "Hello", fontSize = 30f.sp)
        Text(text = "Hello", fontSize = 80.0.sp)

        val story = "AAAAAAAAAAA\n" +
                "BBBBBBBBBBBBBB\n" +
                "CCCCCCCCCCCCCCC"
        Text(text = story, color = Color.Red)
        Text(text = story, color = Color.Blue, maxLines = 2)
        Text(text = story, color = Color.Green, maxLines = 1)

        Text(
            text = "Hello",
            modifier = Modifier
                .background(Color.Gray)
                .border(1.dp, Color.Red)
                .padding(5.dp)
        )

        Text(
            text = "Hello",
            modifier = Modifier
                .background(color = Color(0xff66cdaa))
                .padding(20.dp)
        )

        Button(
            onClick = { Log.d("Button", "onClick") }
        ) {
            Text(text = "Button")
        }

        var count by remember { mutableStateOf(0) }
        Text(
            text = "Tap count: $count",
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = { count++ }
        ) {
            Text(text = "Count up!")
        }

        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "LLLabel") },
            modifier = Modifier.padding(20.dp)
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.padding(20.dp).width(200.dp),
            singleLine = false,
            maxLines = 5
        )
    }
}

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

// @Preview アノテーションを追加します。[プレビュー] ペインに表示されます。
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTestTheme {
        Greeting("Android")
    }
}
*/