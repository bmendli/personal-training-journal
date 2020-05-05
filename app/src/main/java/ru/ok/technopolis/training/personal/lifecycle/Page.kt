package ru.ok.technopolis.training.personal.lifecycle

import android.app.Activity
import ru.ok.technopolis.training.personal.activities.LoginActivity
import ru.ok.technopolis.training.personal.activities.settings.AccountSettingsActivity
import ru.ok.technopolis.training.personal.activities.settings.SettingsActivity
import ru.ok.technopolis.training.personal.fragments.ActiveExerciseFragment
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.fragments.CalendarFragment
import ru.ok.technopolis.training.personal.fragments.ExerciseFragment
import ru.ok.technopolis.training.personal.fragments.WorkoutFragment
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

    }

    sealed class Fragment : Page() {

        abstract val clazz: KClass<out BaseFragment>

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
    }

    companion object {
        val PAGE_KEY = "PAGE"
    }
}