package ru.ok.technopolis.training.personal.activities.settings

import android.os.Bundle
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.activities.BaseFragmentActivity

class AccountSettingsActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router?.showAccountSettingsSubPage()
    }

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun canOpenNavMenuFromToolbar(): Boolean = false
}