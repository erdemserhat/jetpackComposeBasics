package com.erdemserhat.jetpackcomposebasics.starter.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemserhat.jetpackcomposebasics.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Card()


            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardPreview(){
    Card()
}

@Composable
fun Card(modifier: Modifier=Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        PhotoWithDescription(
            modifier = modifier
                .align(Alignment.Center)


        )

        ContactInformation(
            modifier = modifier
                .align(Alignment.BottomCenter)

        )

    }


}

@Composable
fun PhotoWithDescription(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.software_engineer_graphic_clipart_design_free_png)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  modifier

    ) {
        Image(
          painter = image,
          contentDescription =null,
          modifier = modifier
              .requiredSize(250.dp)
        )

        Text(
            text = stringResource(id = R.string.full_name),
            fontSize = 36.sp,
            modifier = modifier

        )
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 24.sp,
            modifier = modifier
        )

    }

}

@Composable
fun ContactInformationPrototype(
    titleId:Int,
    IconId:Int,
    modifier:Modifier = Modifier){
    val title = stringResource(id = titleId)
    val image = painterResource(id = IconId)

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ){
       Image(
           painter = image,
           contentDescription = null,
           modifier = modifier
       )
        Text(
            text = title,
            modifier = modifier
        )

    }


}

@Composable
fun ContactInformation(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .padding(bottom = 12.dp)

    ) {
        ContactInformationPrototype(titleId = R.string.mail, IconId = R.drawable.baseline_mail_24)
        ContactInformationPrototype(titleId = R.string.phone_number, IconId = R.drawable.baseline_local_phone_24)
        ContactInformationPrototype(titleId = R.string.address, IconId = R.drawable.baseline_my_location_24)

    }
}

