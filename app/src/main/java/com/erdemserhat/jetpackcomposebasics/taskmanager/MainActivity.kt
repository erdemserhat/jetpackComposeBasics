package com.erdemserhat.jetpackcomposebasics.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.taskmanager.ui.theme.JetpackComposeBasicsTheme

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
                    Indicator(
                        stringResource(id = R.string.information_text),
                        stringResource(id = R.string.information_text2)
                    )
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun IndicatorPreview(){
    Indicator(
        stringResource(id = R.string.information_text),
        stringResource(id = R.string.information_text2)
    )

}

@Composable
fun Indicator(text1:String, text2:String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null
        )

        Text(
            text = text1,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold

        )

        Text(
            text = text2,
            fontSize = 16.sp
        )

    }

}

