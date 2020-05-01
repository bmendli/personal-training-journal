package ru.ok.technopolis.training.personal.config

import android.content.Context
import android.content.RestrictionsManager
import android.content.res.Resources
import android.os.Bundle
import ru.ok.technopolis.training.personal.App

object Config {

    private const val BACKEND_KEY = "backendAddressURL"

    private val resources: Resources? = App.instance.resources

    private val appRestrictions: Bundle

    init {
        val restrictionManager = App.instance.getSystemService(Context.RESTRICTIONS_SERVICE)
                as RestrictionsManager

        appRestrictions = restrictionManager.applicationRestrictions
    }


    fun getBackendAddress() = appRestrictions.getString(BACKEND_KEY)
            ?: throw Resources.NotFoundException(BACKEND_KEY)
}