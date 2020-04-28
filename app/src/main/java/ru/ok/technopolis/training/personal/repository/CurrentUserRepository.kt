package ru.ok.technopolis.training.personal.repository

import ru.ok.technopolis.training.personal.model.UserInfo

object CurrentUserRepository {

    private val currentUser: UserInfo = UserInfo(
            uid = 0,
            lastName = "lastName",
            firstName = "firstName",
            fatherName = "fatherName",
            genderType = UserInfo.GenderType.MALE,
            email = "email",
            birthday = null,
            pictureUrlStr = null)

    @JvmStatic
    fun getCurrentUserInfo(): UserInfo = currentUser
}