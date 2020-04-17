package ru.ok.technopolis.training.personal.utils

import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

interface ExerciseListener {
    fun onExerciseAdding()
    fun onExerciseCanceled(element: WorkoutElement)
    fun onExerciseClicked(element: WorkoutElement)
    fun onExerciseSaved(element: WorkoutElement)
}
