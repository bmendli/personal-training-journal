package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.utils.logger.Logger
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

abstract class BaseSettingsActivity : BaseActivity() {

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
