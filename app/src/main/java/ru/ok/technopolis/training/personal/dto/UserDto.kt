package ru.ok.technopolis.training.personal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.ok.technopolis.training.personal.model.UserInfo
import java.util.*

data class UserDto(
    @SerializedName("uid")
    @Expose
    val uid: Long,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("father_name")
    @Expose
    val fatherName: String?,
    @SerializedName("father_name")
    @Expose
    val genderType: String,
    @SerializedName("email")
    @Expose
    val email: String?,
    @SerializedName("birthday")
    @Expose
    val birthday: Date?,
    @SerializedName("picture_url")
    @Expose
    val pictureUrlStr: String?
) {

    fun toUserInfo(): UserInfo = UserInfo(
            uid,
            lastName,
            firstName,
            fatherName,
            UserInfo.GenderType.fromApiStr(genderType),
            email,
            birthday,
            pictureUrlStr
    )
}