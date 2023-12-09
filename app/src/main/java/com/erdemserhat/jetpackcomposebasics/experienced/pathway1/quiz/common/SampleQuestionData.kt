package com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.common

import com.erdemserhat.jetpackcomposebasics.R
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.model.Choice
import com.erdemserhat.jetpackcomposebasics.experienced.pathway1.quiz.model.Question

object SampleQuestionData {
    val questionListSample = listOf<Question>(
        Question(
            "Which programming Language is future of backend?",
            listOf<Choice>(
                Choice("Java", R.drawable.java),
                Choice("Swift",R.drawable.swift),
                Choice("C",R.drawable.c),
                Choice("Java Script",R.drawable.js)

            )
        )

    )
}