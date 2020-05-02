package ru.ok.technopolis.training.personal.activities

import android.content.Context
import android.os.Bundle
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.api.Api
import ru.ok.technopolis.training.personal.repository.AuthRepository
import ru.ok.technopolis.training.personal.utils.logger.Logger
import java.net.HttpURLConnection

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = getSharedPreferences(AuthRepository.TRAINING_PREFERENCE, Context.MODE_PRIVATE)
                .getString(AuthRepository.USER_TOKEN, null)

        if (token != null) {
            compositeDisposable.add(
                    Api.login(token).subscribe(
                            {
                                if (it.code() == HttpURLConnection.HTTP_OK) {
                                    AuthRepository.doOnLogin(this, token, false)
                                    Logger.d(this, "successfully login with code ${it.code()}")
                                } else {
                                    router?.showLoginPage()
                                    Logger.d(this, it.code())
                                    finish()
                                }
                            },
                            {
                                router?.showLoginPage()
                                Logger.e(this, it.message ?: it)
                                finish()
                            }
                    )
            )
        } else {
            router?.showLoginPage()
            finish()
        }
    }

    override fun getActivityLayoutId() = R.layout.activity_welcome
}