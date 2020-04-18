package ru.ok.technopolis.training.personal.activities.settings

import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import kotlinx.android.synthetic.main.view_appbar.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.settings.SettingsFragment

class SettingsActivity : BaseSettingsActivity() {

    override fun hasNavigationMenu(): Boolean = false

    override fun getToolbarTitle(): String = getString(R.string.settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = SettingsFragment()

    override fun getToolbarView(): Toolbar = base_toolbar

    override fun getActivityLayoutId(): Int = R.layout.activity_base_fragment
}
