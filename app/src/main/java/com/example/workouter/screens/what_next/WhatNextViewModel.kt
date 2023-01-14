package com.example.workouter.screens.what_next

import com.example.workouter.CHOOSE_EXERCISE_DESTINATION
import com.example.workouter.HOME_DESTINATION

class WhatNextViewModel {

    fun clickOnContinue(goTo: (String) -> Unit) {
        goTo(CHOOSE_EXERCISE_DESTINATION)
    }

    fun clickOnEndTraining(goTo: (String) -> Unit) {
        goTo(HOME_DESTINATION)
    }
}