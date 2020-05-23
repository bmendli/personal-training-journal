package ru.ok.technopolis.training.personal.db.model

import androidx.room.Embedded
import androidx.room.Relation
import ru.ok.technopolis.training.personal.db.entity.UserEntity
import ru.ok.technopolis.training.personal.db.entity.WorkoutEntity

data class UserWorkoutModel(
    @Embedded
    var user: UserEntity,
    @Relation(parentColumn = "id", entity = WorkoutEntity::class, entityColumn = "userId")
    var workouts: List<WorkoutEntity>
)
