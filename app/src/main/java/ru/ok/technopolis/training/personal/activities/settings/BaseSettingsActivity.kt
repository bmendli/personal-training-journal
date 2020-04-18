package ru.ok.technopolis.training.personal.activities.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.activities.AppbarActivity

abstract class BaseSettingsActivity : AppbarActivity() {

    companion object {
        const val EMPTY_KEY = "KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSettingsFragment()
    }

    private fun setSettingsFragment() {
        supportFragmentManager.beginTransaction().add(R.id.main_container, getPreferencesFragment()).commit()
        supportFragmentManager.executePendingTransactions()
    }

    abstract fun getPreferencesFragment(): PreferenceFragmentCompat
}
