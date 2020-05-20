package ru.ok.technopolis.training.personal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.ok.technopolis.training.personal.db.entity.interfaces.WithId

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MeasureUnitEntity::class,
            parentColumns = ["id"],
            childColumns = ["measureUnitId"]
        ),
        ForeignKey(
            entity = ParameterTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["parameterTypeId"]
        )
    ]
)
data class ParameterEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var measureUnitId: Int,
    @ColumnInfo var parameterTypeId: Int
) : WithId()
