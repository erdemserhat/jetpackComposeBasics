package com.erdemserhat.jetpackcomposebasics.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erdemserhat.jetpackcomposebasics.tutorial.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Magenta),
        verticalArrangement = Arrangement.spacedBy(
            space = 32.dp, // space between children
            alignment = Alignment.CenterVertically
        )
    ) {
        Text(
            modifier = Modifier.border(width = 1.dp, color = Color.Green),
            text = "SemicolonSpace 1"
        )
        Text(
            modifier = Modifier.border(width = 1.dp, color = Color.Green),
            text = "SemicolonSpace 2"
        )
        Text(
            modifier = Modifier.border(width = 1.dp, color = Color.Green),
            text = "SemicolonSpace 3"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}