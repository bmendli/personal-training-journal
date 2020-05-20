package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity
data class UserEntity(
    @ColumnInfo var firstName: String,
    @ColumnInfo var lastName: String?,
    @ColumnInfo var email: String,
    @ColumnInfo var gender: String,
    @ColumnInfo var avatarUrl: String
) : WithId()
