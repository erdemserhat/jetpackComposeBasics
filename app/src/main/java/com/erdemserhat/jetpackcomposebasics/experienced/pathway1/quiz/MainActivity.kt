package com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.common.SampleQuestionData
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.model.Choice
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.model.Question
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.ui.theme.JetpackComposeBasicsTheme

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
    uiMode = UI_MODE_NIGHT_YES,
    name = "Nigh Mode"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "Light Mode"
)
@Composable
fun QuestionCardPreview(){
    JetpackComposeBasicsTheme {
        Surface {
            QuestionCard(SampleQuestionData.questionListSample[0])

        }
    }
}

@Composable
fun Choices(choices: List<Choice>) {
    var selectedChoice:Choice? by
        rememberSaveable { mutableStateOf(null) }


    Column {
        for (choice in choices) {
            Answer(
                choice = choice,
                isSelected = (selectedChoice==choice)

                )

        }
    }
}

@Composable
fun QuestionCard(question: Question){


    Column {
        Text(text = question.title)
        Choices(
            choices = question.choices,

        )
    }


}

@Composable
fun Answer(choice:Choice,isSelected:Boolean){
    Row {

        Image(
            painter = painterResource(id = choice.iconId),
            contentDescription = null,
            modifier = Modifier
                .requiredSize(30.dp)
                .clip(CircleShape)

        )
        Spacer(modifier= Modifier.width(4.dp))
        Text(text = choice.title,
            textAlign = TextAlign.Justify
        )
        Spacer(modifier= Modifier.width(4.dp))
        RadioButton(
            selected = isSelected,
            onClick = { /*TODO*/ },

            )

    }
    
}

