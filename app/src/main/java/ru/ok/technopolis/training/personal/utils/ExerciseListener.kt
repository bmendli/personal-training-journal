package ru.ok.technopolis.training.personal.utils

interface ExerciseListener {
    fun onExerciseAdding()
    fun onExerciseClicked(exerciseIndex: Int)
    fun onExerciseSaved(exerciseIndex: Int)
    fun onExerciseCanceled(exerciseIndex: Int)
}