package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity
data class WorkoutEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var description: String?
) : WithId()
