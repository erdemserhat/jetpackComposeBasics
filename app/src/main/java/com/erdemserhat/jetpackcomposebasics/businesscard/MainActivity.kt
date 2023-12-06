package com.erdemserhat.jetpackcomposebasics.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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


            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewCard(){
    Card()

}

@Composable
fun Card(modifier: Modifier = Modifier){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(top = 160.dp)
            .padding(start = 30.dp)
    ) {
        CardPhoto()


        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier
                .padding(top = 150.dp)

        ) {
            ContactInformation(R.string.mail, R.drawable.baseline_mail_24)
            ContactInformation(
                contactTitleId = R.string.address,
                contactIconId = R.drawable.baseline_my_location_24
            )
            ContactInformation(
                contactTitleId = R.string.phone_number,
                contactIconId = R.drawable.baseline_local_phone_24
            )
        }
    }








}

@Composable
fun CardPhoto(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.software_engineer_graphic_clipart_design_free_png)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .requiredSize(250.dp)
    )

    Text(
        text = stringResource(id = R.string.full_name),
        fontSize = 24.sp,
        modifier = modifier
    )

    Text(
        text = stringResource(id = R.string.title),
        fontSize = 24.sp
    )
}

@Composable

fun ContactInformation(
    contactTitleId:Int,
    contactIconId:Int,
    modifier: Modifier = Modifier){

    val contactIcon = painterResource(id = contactIconId)
    val contactTitle = stringResource(id = contactTitleId)

    Column(
        modifier = modifier
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement =  Arrangement.Start
        ) {
            Image(painter = contactIcon, contentDescription = null)
            Text(
                text = contactTitle,
                modifier = modifier
                    .padding(start = 5.dp)
            )
        }
    }




}
