package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = UserWorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["userWorkoutId"]
        ),
        ForeignKey(
            entity = ParameterEntity::class,
            parentColumns = ["id"],
            childColumns = ["parameterId"]
        )
    ]
)
data class UserWorkoutParameterValueEntity(
    @ColumnInfo var userWorkoutId: Int,
    @ColumnInfo var parameterId: Int,
    @ColumnInfo var value: Float
) : WithId()
