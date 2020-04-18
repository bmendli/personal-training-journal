package ru.ok.technopolis.training.personal.activities

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.AccountSettingsFragment

class AccountSettingsActivity : BaseActivity() {

    override fun getSupportingFragment(): Fragment = AccountSettingsFragment()

    override fun hasNavigationMenu(): Boolean = false

    override fun getToolbarTitle(): String = getString(R.string.account_settings)
}