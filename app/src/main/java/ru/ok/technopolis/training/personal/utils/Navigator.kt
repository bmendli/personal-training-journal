package ru.ok.technopolis.training.personal.utils

import android.content.Context
import android.content.Intent
import ru.ok.technopolis.training.personal.activities.SettingsActivity

object Navigator {

    @JvmStatic
    fun onSearchItemClicked() {

    }

    @JvmStatic
    fun onBookmarksItemClicked() {

    }

    @JvmStatic
    fun onFavouriteItemClicked() {

    }

    @JvmStatic
    fun onSettingsItemClicked(context: Context) {
        context.startActivity(Intent(context, SettingsActivity::class.java))
    }
}