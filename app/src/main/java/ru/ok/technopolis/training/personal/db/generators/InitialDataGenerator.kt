package ru.ok.technopolis.training.personal.db.generators

import ru.ok.technopolis.training.personal.db.entity.ExerciseTypeEntity
import ru.ok.technopolis.training.personal.db.entity.MeasureUnitEntity
import ru.ok.technopolis.training.personal.db.entity.ParameterTypeEntity

// TODO: load initial data from the server with current app locale
class InitialDataGenerator {
    companion object {
        fun getParameterTypes(): List<ParameterTypeEntity> {
            return listOf(
                ParameterTypeEntity("Цель", true),
                ParameterTypeEntity("Результат", false)
            )
        }
        fun getExerciseTypes(): List<ExerciseTypeEntity> {
            return listOf(
                ExerciseTypeEntity("Силовое"),
                ExerciseTypeEntity("Кардио"),
                ExerciseTypeEntity("Координация"),
                ExerciseTypeEntity("Опорно-двигательное")
            )
        }
        fun getMeasureUnits(): List<MeasureUnitEntity> {
            return listOf(
                MeasureUnitEntity("Миллиметры", "мм"),
                MeasureUnitEntity("Сантиметры", "см"),
                MeasureUnitEntity("Метры", "м"),
                MeasureUnitEntity("Километры", "км"),
                MeasureUnitEntity("Единицы", "ед"),
                MeasureUnitEntity("Секунды", "сек"),
                MeasureUnitEntity("Минуты", "мин"),
                MeasureUnitEntity("Часы", "ч")
            )
        }
    }
}