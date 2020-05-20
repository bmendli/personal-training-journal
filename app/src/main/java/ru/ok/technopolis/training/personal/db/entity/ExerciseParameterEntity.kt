package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"]
        ),
        ForeignKey(
            entity = ParameterEntity::class,
            parentColumns = ["id"],
            childColumns = ["parameterId"]
        )
    ]
)
data class ExerciseParameterEntity(
    @ColumnInfo var exerciseId: Int,
    @ColumnInfo var parameterId: Int
) : WithId()
