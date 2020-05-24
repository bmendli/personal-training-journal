package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.api.Api
import ru.ok.technopolis.training.personal.repository.AuthRepository
import ru.ok.technopolis.training.personal.repository.CurrentUserRepository
import ru.ok.technopolis.training.personal.utils.logger.Logger
import java.net.HttpURLConnection

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUserFromStorage = CurrentUserRepository.getCurrentUserFromStorage(this)
        val token = CurrentUserRepository.getCurrentUserToken(this)

        if (token != null) {
            if (currentUserFromStorage != null) {
                AuthRepository.doOnLogin(this, token, false, currentUserFromStorage)
                Logger.d(this, "successfully login from storage")
            } else {
                taskContainer.add(
                        Api.login(token).subscribe(
                                {
                                    if (it.code() == HttpURLConnection.HTTP_OK) {
                                        AuthRepository.doOnLogin(this, token, false,
                                                it.body()?.toUserInfo()
                                                        ?: CurrentUserRepository.CURRENT_USER_EMPTY)
                                        Logger.d(this, "successfully login with code ${it.code()}")
                                    } else {
                                        router?.showLoginPage()
                                        Logger.d(this, "Incorrect password or email : ${it.code()}")
                                        finish()
                                    }
                                },
                                {
                                    router?.showLoginPage()
                                    Logger.e(this, "Login failed : ${it.message}")
                                    finish()
                                }
                        )
                )
            }
        } else {
            router?.showLoginPage()
            finish()
        }
    }

    override fun getActivityLayoutId() = R.layout.activity_welcome
}