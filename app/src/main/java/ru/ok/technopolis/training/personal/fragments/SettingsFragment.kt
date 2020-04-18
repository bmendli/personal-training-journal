package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.fragment_settings)
    }
}