package ru.ok.technopolis.training.personal.utils

interface ExerciseListener {
    fun onExerciseAdding()
    fun onExerciseClicked(id: String)
    fun onExerciseSaved(id: String)
}
