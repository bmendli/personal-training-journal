package ru.ok.technopolis.training.personal.activities

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.ExerciseFragment
import ru.ok.technopolis.training.personal.fragments.WorkoutFragment
import ru.ok.technopolis.training.personal.utils.ExerciseListener
import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

class WorkoutActivity : BaseActivity(), ExerciseListener {

    override fun getSupportingFragment(): Fragment = WorkoutFragment()

    override fun onExerciseAdding() {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseClicked(element: WorkoutElement) {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseSaved(element: WorkoutElement) {
        setFragment(WorkoutFragment())
    }

    override fun onExerciseCanceled(element: WorkoutElement) {
        setFragment(WorkoutFragment())
    }

    override fun getToolbarTitle(): String = getString(R.string.workout)
}
