package ru.ok.technopolis.training.personal.db.model

import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity

data class ParameterModel(
    var parameter: ParameterEntity,
    var measureUnitChoices: MutableList<MeasureUnitEntity>,
    var parameterTypeChoices: MutableList<ParameterTypeEntity>
)
