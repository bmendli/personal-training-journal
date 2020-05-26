package ru.ok.technopolis.training.personal.db.model

import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterEntity

data class ParameterModel(
    var parameter: ParameterEntity,
    var measureUnitChoices: MutableList<MeasureUnitEntity>
)
