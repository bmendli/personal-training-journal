package ru.ok.technopolis.training.personal

import android.app.Application
import ru.ok.technopolis.training.personal.config.Config
import ru.ok.technopolis.training.personal.utils.logger.Logger

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Logger.d(this, "from config: ${Config.getBackendAddress()}", "task2")
    }

    companion object {
        lateinit var instance: App
    }
}