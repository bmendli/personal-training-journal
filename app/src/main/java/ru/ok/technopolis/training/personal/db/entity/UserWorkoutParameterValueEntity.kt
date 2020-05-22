package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
    @ColumnInfo var userWorkoutId: Long,
    @ColumnInfo var parameterId: Long,
    @ColumnInfo var value: Float,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)

