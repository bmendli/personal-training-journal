package ru.ok.technopolis.training.personal.db.model

import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterResultEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity

data class ParameterResultModel(
    var parameter: ParameterEntity,
    var resultsParameterList: MutableList<ParameterResultEntity>,
    var measureUnitChoices: MutableList<MeasureUnitEntity>,
    var parameterTypeChoices: MutableList<ParameterTypeEntity>
)
