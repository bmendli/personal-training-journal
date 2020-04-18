package ru.ok.technopolis.training.personal.activities.settings

import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.settings.SettingsFragment

class SettingsActivity : BaseSettingsActivity() {

    override fun getToolbarTitle(): String = getString(R.string.settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = SettingsFragment()
}
