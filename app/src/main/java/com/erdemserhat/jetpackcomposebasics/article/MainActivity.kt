package com.erdemserhat.jetpackcomposebasics.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.article.ui.theme.JetpackComposeBasicsTheme

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
                    TutorialImage()
                }
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TutorialInformationPreview(){

        TutorialImage()

}

@Composable
fun TutorialImage(modifier:Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null
        )

        TutorialText(
            stringResource(id = R.string.tutorial_title),
            stringResource(id = R.string.tutorial_short),
            stringResource(id = R.string.tutorial_description))




    }


}

@Composable
fun TutorialText(title:String,short:String,description:String,modifier: Modifier = Modifier){
    Column {
        Text(
            text = title,
            fontSize = 25.sp,
            modifier = modifier
                .padding(16.dp)
        )

        Text(
            text = short,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = description,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}