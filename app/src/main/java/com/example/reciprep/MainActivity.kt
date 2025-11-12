package com.example.reciprep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reciprep.ui.theme.ReciprepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReciprepTheme {
                SmallTopAppBarExample()
            }

            VerticalDiv()
            VerticalDiv()
            VerticalDiv()

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(text = "Yellow submarine",
        modifier = modifier.padding(100.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReciprepTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Small Top App Bar")
                }

            )
        },



    ) { innerPadding ->

        Greeting(
            name = "Android",
            modifier = Modifier
                .padding(innerPadding)


        )
        Text(text = "Yellow Helicopter")


    }

}

@Composable
fun ScrollContent(x0: PaddingValues) {
    TODO("Not yet implemented")
}

@Composable
fun VerticalDiv() {

    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Item 1")
        Text("Item 2")
    }

}


