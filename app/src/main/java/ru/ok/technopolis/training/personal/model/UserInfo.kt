package ru.ok.technopolis.training.personal.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

class UserInfo(
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
    }

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString() ?: NAME_UNKNOWN,
            parcel.readString(),
            parcel.readSerializable() as GenderType,
            parcel.readString(),
            parcel.readSerializable() as Date,
            parcel.readString()
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            it.writeLong(uid)
            it.writeString(lastName)
            it.writeString(firstName)
            it.writeString(fatherName)
            it.writeSerializable(genderType)
            it.writeString(email)
            it.writeSerializable(birthday)
            it.writeString(pictureUrlStr)
        }
    }

    override fun describeContents(): Int = 0

    enum class GenderType {
        MALE,
        FEMALE,
        UNKNOWN;

        fun toInteger(): Int {
            return when (this) {
                MALE -> 0
                FEMALE -> 1
                else -> 2
            }
        }

        fun toApiStr(): String {
            return when (this) {
                MALE -> "male"
                FEMALE -> "female"
                else -> "unknown"
            }
        }

        companion object {
            fun fromInteger(gender: Int): GenderType {
                return when (gender) {
                    0 -> MALE
                    1 -> FEMALE
                    else -> UNKNOWN
                }
            }

            fun fromApiStr(gender: String): GenderType {
                return when (gender) {
                    "male" -> MALE
                    "female" -> FEMALE
                    else -> UNKNOWN
                }
            }
        }
    }
}