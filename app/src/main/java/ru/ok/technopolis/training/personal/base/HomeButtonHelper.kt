package ru.ok.technopolis.training.personal.base

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import ru.ok.technopolis.training.personal.R

object HomeButtonHelper {

    @JvmStatic
    fun initHomeButton(activity: AppCompatActivity) {
        if (activity.supportActionBar == null) {
            return
        }

        activity.supportActionBar?.let {
            it.displayOptions = ActionBar.DISPLAY_HOME_AS_UP
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setHomeAsUpIndicator(
                    AppCompatResources.getDrawable(
                            activity,
                            R.drawable.ic_home_button
                    )
            )
        }
    }
}