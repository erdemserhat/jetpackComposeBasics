package com.erdemserhat.jetpackcomposebasics.starter.exampleui

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.starter.article.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    private lateinit var videoUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //videoUri = Uri.parse("android.resource://com.erdemserhat.jetpackcomposebasics/${R.raw.untitled_project}")
                    VideoPlayer(videoUri)



                }
            }
        }

    }
}

@Composable

fun VideoPlayer(videoUri: Uri, modifier: Modifier = Modifier) {
    val context = LocalContext.current


    AndroidView(factory = {
        VideoView(context).apply {
            setVideoURI(videoUri)
            start()
        }
    },
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
}

@Preview
@Composable
fun Preview(){

    VideoPlayer(videoUri = Uri.parse("android.resource://com.erdemserhat.jetpackcomposebasics/${R.raw.untitled_project}"))
}

