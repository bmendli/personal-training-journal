package ru.ok.technopolis.training.personal.repository

import android.content.Context
import ru.ok.technopolis.training.personal.activities.BaseActivity
import ru.ok.technopolis.training.personal.model.UserInfo

object AuthRepository {

    const val TRAINING_PREFERENCE = "Training"
    const val USER_TOKEN = "user_token_key"

    fun doOnLogin(activity: BaseActivity, token: String, needRemember: Boolean, userInfo: UserInfo) {
        activity.apply {
            CurrentUserRepository.currentUser = userInfo
            if (needRemember) {
                getSharedPreferences(TRAINING_PREFERENCE, Context.MODE_PRIVATE).edit().putString(USER_TOKEN, token).apply()
            }
            router?.showWorkoutPage()
            finish()
        }
    }

    fun doOnLogout(activity: BaseActivity) {
        activity.apply {
            CurrentUserRepository.currentUser = null
            getSharedPreferences("Training", Context.MODE_PRIVATE).edit().remove(USER_TOKEN).apply()
            router?.showLoginPage()
            finish()
        }
    }
}