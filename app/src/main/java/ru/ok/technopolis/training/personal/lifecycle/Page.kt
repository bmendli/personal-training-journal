package ru.ok.technopolis.training.personal.lifecycle

import ru.ok.technopolis.training.personal.activities.auth.LoginActivity
import ru.ok.technopolis.training.personal.activities.auth.RegistrationActivity
import ru.ok.technopolis.training.personal.activities.settings.AccountSettingsActivity
import ru.ok.technopolis.training.personal.activities.settings.SettingsActivity
import ru.ok.technopolis.training.personal.fragments.ActiveExerciseFragment
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.fragments.CalendarFragment
import ru.ok.technopolis.training.personal.fragments.ExerciseFragment
import ru.ok.technopolis.training.personal.fragments.ResultsFragment
import ru.ok.technopolis.training.personal.fragments.TrainingViewFragment
import ru.ok.technopolis.training.personal.fragments.WorkoutFragment
import ru.ok.technopolis.training.personal.fragments.settings.AccountSettingsFragment
import java.io.Serializable
import kotlin.reflect.KClass

sealed class Page : Serializable {

    sealed class Activity : Page() {

        abstract val clazz: KClass<out android.app.Activity>

        object Login : Activity() {
            override val clazz = LoginActivity::class
        }

        object Settings : Activity() {
            override val clazz = SettingsActivity::class
        }

        object AccountSettings : Activity() {
            override val clazz = AccountSettingsActivity::class
        }

        object Registration : Activity() {
            override val clazz = RegistrationActivity::class
        }
    }

    sealed class Fragment : Page() {

        abstract val clazz: KClass<out BaseFragment>

        object AccountSettings : Fragment() {
            override val clazz = AccountSettingsFragment::class
        }

        object Results : Fragment() {
            override val clazz = ResultsFragment::class
        }

        object ActiveExercise : Fragment() {
            override val clazz = ActiveExerciseFragment::class
        }

        object Calendar : Fragment() {
            override val clazz = CalendarFragment::class
        }

        object Exercise : Fragment() {
            override val clazz = ExerciseFragment::class
        }

        object Workout : Fragment() {
            override val clazz = WorkoutFragment::class
        }

        object TrainingView : Fragment() {
            override val clazz = TrainingViewFragment::class
        }
    }

    companion object {
        const val PAGE_KEY = "PAGE"
        const val USER_ID_KEY = "USER_ID"
        const val WORKOUT_ID_KEY = "WORKOUT_ID"
        const val EXERCISE_ID_KEY = "EXERCISE_ID"
    }
}