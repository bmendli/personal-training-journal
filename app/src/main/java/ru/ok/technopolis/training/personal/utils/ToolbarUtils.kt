package ru.ok.technopolis.training.personal.utils

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import ru.ok.technopolis.training.personal.R

fun AppCompatActivity.initHomeButton() {
    this.supportActionBar?.let {
        it.displayOptions = ActionBar.DISPLAY_HOME_AS_UP
        it.setHomeButtonEnabled(true)
        it.setDisplayShowHomeEnabled(true)
        it.setHomeAsUpIndicator(this.getDrawable(R.drawable.ic_home_button))
    }
}
