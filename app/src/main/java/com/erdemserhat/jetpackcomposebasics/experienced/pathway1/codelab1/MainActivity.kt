package com.erdemserhat.jetpackcomposebasics.experienced.pathway1.codelab1

import android.R.style
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.codelab1.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting the content of activity
        setContent {
            //Setting the Main theme in parent content
            JetpackComposeBasicsTheme {
                //calling the parent composable

            }

        }
    }
}

@Preview(
    name = "Light Mode",
)

@Composable
fun AppPreview() {
    JetpackComposeBasicsTheme {
        //calling the parent composable
        MyApp()

    }
}

@Composable
fun MyApp(){
    var shouldShowOnBoarding by remember {
        mutableStateOf(true)
        //Whenever "shouldShowBoarding" value changes this,
        //recomposition happens that's why if/else statement re-evaluated.
    }
    if(shouldShowOnBoarding){
        OnboardingScreen(onContinueClicked = {shouldShowOnBoarding=false})
    }else{
        Greetings()
    }
}

@Composable
fun Greetings(names: List<String> = List(1000){"$it"}) {
    Surface() {
        Column(
            modifier = Modifier.padding(4.dp)

        ) {
          LazyColumn{

              item { Text(text = "My List") }
              items(names){name->
                  Greeting(name)
              }
              //items,item etc special to lazyColumns and lazyRow

          }

        }

    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        targetValue = if (isExpanded) 48.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 500
        ),
        label = ""

    )
    //If this process would need too cpu or takes time to be calculated
    //we would have needed to be use "remember" keyword

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)//Tells the parent this child(in this case Column) want to be flexible
                    .padding(bottom = extraPadding)

            ) {
                Text(text = "Hello,")
                Text(
                    text = name,
                    style=MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold))

            if(isExpanded){
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
            //
            }
            IconButton(onClick = { isExpanded =!isExpanded }) {
               Icon(
                   imageVector = if(isExpanded) Icons.Filled.Info else Icons.Filled.Add,
                   contentDescription = if (isExpanded) {
                       stringResource(R.string.show_less)
                   } else {
                       stringResource(R.string.show_more)
                   })
                
            }


            //


        }


    }
}

@Composable
fun OnboardingScreen(onContinueClicked:()->Unit,modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!",style = MaterialTheme.typography.headlineSmall   )
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = UI_MODE_NIGHT_YES

)
@Composable
fun OnboardingPreview() {
    com.erdemserhat.jetpackcomposebasics.experienced.pathway1.onboarding.ui.theme.JetpackComposeBasicsTheme {
        MyApp()
    }
}


