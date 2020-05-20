package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity
data class MeasureUnitEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var acronym: String
) : WithId()
