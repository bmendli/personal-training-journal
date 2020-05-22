package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date
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
    @ColumnInfo var userId: Long,
    @ColumnInfo var workoutId: Long,
    @ColumnInfo var plannedTime: Date,
    @ColumnInfo var weekdaysMask: Int,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)

