package com.example.jetpacktest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacktest.ui.theme.JetpackTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen2()
        }
    }
}

@Composable
fun AppScreen() {

    // Column:縦に並べる
    // Row:横に並べる
    // Box:任意の位置に配置
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

        // border()とpadding()の順番注意
        Text(
            text = "Hello",
            modifier = Modifier
                .background(Color.Gray)// 背景色
                .border(1.dp, Color.Red)// 枠線
                .padding(5.dp)
        )

        Text(
            text = "Hello",
            modifier = Modifier
                .background(color = Color(0xff66cdaa))
                .padding(20.dp)
        )

        // onClick:ボタンをクリックしたときに呼び出されるコールバック関数
        // {}:ボタンの表示を構成するコンポーザブル関数
        Button(
            onClick = { Log.d("Button", "onClick") }
        ) {
            Text(text = "Button")
        }

        // mutableStateOfは、値の変更を監視する
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

        // 目立たせる際はTextField
        // たくさん場合は、うるさくならないようにOutlinedTextField
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "LLLabel") },// ラベル
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
@Composable
fun AppScreen2() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            AnimalComposable(
                resourceId = R.drawable.dog,
                text = "Dog",
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            )
            AnimalComposable(
                resourceId = R.drawable.cat,
                text = "Cat",
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            )
        }
        var isButtonPressed by remember { mutableStateOf(false) }

        QuestionComposable {
            isButtonPressed = true
        }
        if (isButtonPressed) {
            ResponseComposable()
        }
    }
}

@Composable
fun ResponseComposable() {
    Text(
        text = "Thank you!!!",
        fontSize = 25.sp
    )
}
@Composable
fun AnimalComposable(resourceId: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun QuestionComposable(onClick: ()->Unit = {}) {
    Text(
        text = "Do you like animals?",
        fontSize = 25.sp,
        modifier = Modifier.padding(vertical = 10.dp)
    )
    Button(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(text = "Yes")
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