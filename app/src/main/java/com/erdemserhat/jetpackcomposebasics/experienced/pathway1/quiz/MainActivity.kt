package com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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

//To Preview
@Preview(
    name = "Nigh Mode",
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun QuestionPreview() {
    QuestionScreen()

}

@Composable
fun QuestionScreen() {
    //State hoisting
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }
    QuestionContent(
        question = SampleQuestionData.questionListSample[0],
        onUserClicked = { isSelected = !isSelected },
        isSelected = isSelected

    )


}


@Composable
fun QuestionContent(question: Question, onUserClicked: () -> Unit, isSelected: Boolean) {
    Column {
        Text(text = question.title)
        question.choices.forEach { choice ->
            ChoiceItem(choice)


        }



    }


}

@Composable
fun ChoiceItem(choice:Choice) {
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }


        Row {
            Image(
                painter = painterResource(id = choice.iconId),
                contentDescription = null,
                modifier = Modifier.requiredSize(20.dp)


            )
            Text(text = choice.title)
            RadioButton(selected = isSelected, onClick = {isSelected=!isSelected})

    }


}




