package ru.ok.technopolis.training.personal.activities.settings

import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.settings.AccountSettingsFragment

class AccountSettingsActivity : BaseSettingsActivity() {

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = AccountSettingsFragment()
}