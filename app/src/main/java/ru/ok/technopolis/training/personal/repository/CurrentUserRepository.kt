package ru.ok.technopolis.training.personal.repository

import android.content.Context
import ru.ok.technopolis.training.personal.model.UserInfo

object CurrentUserRepository {

    val CURRENT_USER_EMPTY: UserInfo = UserInfo(
            id = -1,
            uid = "-1",
            lastName = "lastName",
            firstName = "firstName",
            fatherName = "fatherName",
            genderType = UserInfo.GenderType.MALE,
            email = "email",
            birthday = null,
            pictureUrlStr = null)

    var currentUser: UserInfo? = null
        internal set

    fun getCurrentUserToken(context: Context): String? =
            context.getSharedPreferences(AuthRepository.TRAINING_PREFERENCE, Context.MODE_PRIVATE)
                    .getString(AuthRepository.USER_TOKEN, null)
}