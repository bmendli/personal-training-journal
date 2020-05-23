package ru.ok.technopolis.training.personal.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ok.technopolis.training.personal.activities.BaseActivity
import ru.ok.technopolis.training.personal.db.entity.UserEntity

object AuthRepository {

    const val TRAINING_PREFERENCE = "Training"
    const val USER_TOKEN = "user_token_key"

    fun doOnLogin(activity: BaseActivity, token: String, needRemember: Boolean) {
        activity.apply {
            GlobalScope.launch(Dispatchers.IO) {
                val userInfo = CurrentUserRepository.getCurrentUserInfo()
                var user = database?.userDao()?.getByEmail(userInfo.email)
                if (user == null) {
                    user = UserEntity(
                        userInfo.firstName,
                        userInfo.lastName,
                        userInfo.fatherName,
                        userInfo.email,
                        userInfo.genderType.toApiStr(),
                        userInfo.pictureUrlStr
                    )
                    database?.userDao()?.insert(user)
                }
                withContext(Dispatchers.Main) {
                    if (needRemember) {
                        getSharedPreferences(TRAINING_PREFERENCE, Context.MODE_PRIVATE).edit().putString(USER_TOKEN, token).apply()
                    }
                    router?.showCalendarPage()
                    finish()
                }
            }
        }
    }

    fun doOnLogout(activity: BaseActivity) {
        activity.apply {
            getSharedPreferences("Training", Context.MODE_PRIVATE).edit().remove(USER_TOKEN).apply()
            router?.showLoginPage()
            finish()
        }
    }
}