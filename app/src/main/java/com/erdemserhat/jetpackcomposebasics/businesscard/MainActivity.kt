package com.erdemserhat.jetpackcomposebasics.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.businesscard.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
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
fun CardPreview() {
    BusinessCard()

}


@Composable
fun ContactInformation(titleId: Int, imageId: Int, modifier: Modifier = Modifier) {
    Row(
    ) {
        val image = painterResource(id = imageId)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .requiredSize(24.dp)
        )

        Text(
            text = stringResource(id = titleId),
            modifier = Modifier
                .padding(5.dp)
        )
    }

}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.software_engineer_graphic_clipart_design_free_png       )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(top = 150.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .requiredSize(255.dp)
        )

        Text(
            text = stringResource(id = R.string.full_name),
            textAlign = TextAlign.Justify,
            fontSize = 32.sp
        )

        Text(
            text = stringResource(id = R.string.title),
            fontSize = 20.sp
        )


    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            ContactInformation(titleId = R.string.mail, imageId = R.drawable.mailicon)
            ContactInformation(titleId = R.string.phone_number, imageId = R.drawable.baseline_local_phone_24)
            ContactInformation(titleId = R.string.address, imageId = R.drawable.baseline_my_location_24)


        }



    }
}





