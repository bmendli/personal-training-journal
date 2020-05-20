package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ExerciseTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["typeId"]
        )
    ]
)
data class ExerciseEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var description: String?,
    @ColumnInfo var typeId: Int
) : WithId()
