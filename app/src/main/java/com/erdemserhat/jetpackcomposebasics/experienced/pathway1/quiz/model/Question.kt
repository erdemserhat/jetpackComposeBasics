package com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.model

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter

data class Question(
    val title:String,
    val choices:List<Choice>
)
