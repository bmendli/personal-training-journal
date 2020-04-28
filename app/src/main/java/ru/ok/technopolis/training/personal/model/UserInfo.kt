package ru.ok.technopolis.training.personal.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class UserInfo(
    val uid: Long,
    val lastName: String,
    val firstName: String,
    val fatherName: String?,
    val genderType: GenderType,
    val email: String?,
    val birthday: Date?,
    val pictureUrlStr: String?
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<UserInfo> {
        private const val NAME_UNKNOWN = ""

        override fun createFromParcel(parcel: Parcel): UserInfo {
            return UserInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserInfo?> {
            return arrayOfNulls(size)
        }

        fun fromParcel(parcel: Parcel): UserInfo = UserInfo(
                parcel.readLong(),
                parcel.readString() ?: NAME_UNKNOWN,
                parcel.readString() ?: NAME_UNKNOWN,
                parcel.readString(),
                parcel.readSerializable() as GenderType,
                parcel.readString(),
                parcel.readSerializable() as Date,
                parcel.readString()
        )
    }

    constructor(parcel: Parcel) : this(CREATOR.fromParcel(parcel))

    constructor(userInfo: UserInfo): this(
            userInfo.uid,
            userInfo.lastName,
            userInfo.firstName,
            userInfo.fatherName,
            userInfo.genderType,
            userInfo.email,
            userInfo.birthday,
            userInfo.pictureUrlStr
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.apply {
            writeLong(uid)
            writeString(lastName)
            writeString(firstName)
            writeString(fatherName)
            writeSerializable(genderType)
            writeString(email)
            writeSerializable(birthday)
            writeString(pictureUrlStr)
        }
    }

    override fun describeContents(): Int = 0

    enum class GenderType {
        MALE,
        FEMALE,
        UNKNOWN;

        fun toApiStr(): String {
            return when (this) {
                MALE -> MALE_API_NAME
                FEMALE -> FEMALE_API_NAME
                else -> UNKNOWN_API_NAME
            }
        }

        companion object {

            const val MALE_API_NAME = "male"
            const val FEMALE_API_NAME = "female"
            const val UNKNOWN_API_NAME = "unknown"

            fun fromApiStr(gender: String): GenderType {
                return when (gender) {
                    MALE_API_NAME -> MALE
                    FEMALE_API_NAME -> FEMALE
                    else -> UNKNOWN
                }
            }
        }
    }
}