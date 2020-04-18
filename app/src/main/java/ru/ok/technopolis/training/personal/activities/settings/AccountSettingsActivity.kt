package ru.ok.technopolis.training.personal.activities.settings

import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import kotlinx.android.synthetic.main.view_appbar.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.settings.AccountSettingsFragment

class AccountSettingsActivity : BaseSettingsActivity() {

    override fun hasNavigationMenu(): Boolean = false

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = AccountSettingsFragment()

    override fun getToolbarView(): Toolbar = base_toolbar

    override fun getActivityLayoutId(): Int = R.layout.activity_base_fragment
}