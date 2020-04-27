package ru.ok.technopolis.training.personal.repository

import ru.ok.technopolis.training.personal.model.UserInfo

object CurrentUserRepository {

    private val currentUser: UserInfo = UserInfo(0, "lastName", "firstName",
            "fatherName", UserInfo.GenderType.MALE, "email", null, null)

    @JvmStatic
    fun getCurrentUserInfo(): UserInfo = currentUser
}