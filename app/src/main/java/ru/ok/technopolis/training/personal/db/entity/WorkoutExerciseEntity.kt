package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["workoutId"]
        ),
        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"]
        )
    ]
)
data class WorkoutExerciseEntity(
    @ColumnInfo var workoutId: Int,
    @ColumnInfo var exerciseId: Int
) : WithId()
