package ru.ok.technopolis.training.personal.activities

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.SettingsFragment

class SettingsActivity : BaseActivity() {

    override fun getSupportingFragment(): Fragment = SettingsFragment()

    override fun hasNavigationMenu(): Boolean = false

    override fun getToolbarTitle(): String = getString(R.string.settings)

}