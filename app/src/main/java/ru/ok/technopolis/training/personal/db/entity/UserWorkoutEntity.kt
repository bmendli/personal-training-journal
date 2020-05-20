package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId
import java.sql.Time

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["workoutId"]
        )
    ]
)
data class UserWorkoutEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var comments: String?,
    @ColumnInfo var userId: Int,
    @ColumnInfo var workoutId: Int,
    @ColumnInfo var plannedTime: Time,
    @ColumnInfo var weekdaysMask: Int
) : WithId()
