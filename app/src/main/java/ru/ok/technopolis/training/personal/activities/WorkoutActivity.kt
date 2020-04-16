package ru.ok.technopolis.training.personal.activities

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.fragments.ExerciseFragment
import ru.ok.technopolis.training.personal.fragments.WorkoutFragment
import ru.ok.technopolis.training.personal.utils.ExerciseListener

class WorkoutActivity : BaseNoAppbarActivity(), ExerciseListener {

    override fun getSupportingFragment(): Fragment = WorkoutFragment()

    override fun onExerciseAdding() {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseClicked(exerciseIndex: Int) {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseSaved(exerciseIndex: Int) {
        setFragment(WorkoutFragment())
    }

    override fun onExerciseCanceled(exerciseIndex: Int) {
        setFragment(WorkoutFragment())
    }
}
