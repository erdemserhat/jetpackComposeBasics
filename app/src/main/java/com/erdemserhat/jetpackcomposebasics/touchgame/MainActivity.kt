package com.erdemserhat.jetpackcomposebasics.touchgame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.erdemserhat.jetpackcomposebasics.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemserhat.jetpackcomposebasics.touchgame.ui.theme.JetpackComposeBasicsTheme

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
fun GameFrame(modifier: Modifier = Modifier) {
    GeneralFrame()

}

@Composable
fun GeneralFrame(modifier: Modifier = Modifier) {

    Box {
        Row(
            modifier = modifier
                .fillMaxSize()
                .border(5.dp, Color.Yellow)


        ) {
            SidePrototype(
                "Serhat",

                modifier = modifier
                    .border(3.dp,Color.Black)




            )

            SidePrototype(
                "Berkant",

                modifier = modifier

                    .border(3.dp,Color.Green)

            )

        }



    }

}

@Composable
fun SidePrototype(
    playerName:String,
    modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .background(Color.Blue)
            .fillMaxSize()

    ){
        Text(
            text =playerName,
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,

        )

        Column(
            modifier = modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text ="Button 1",
                modifier = modifier
                    .padding(bottom = 20.dp)
                    .clickable { println("Hello") }
                    .background(Color.Red),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,


                )

            Text(
                text ="Button 2",
                modifier = modifier
                    .padding(bottom = 20.dp)
                    .clickable {  println("World")}
                    .background(Color.Red),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,


                )

        }




    }

}


