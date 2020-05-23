package ru.ok.technopolis.training.personal.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import ru.ok.technopolis.training.personal.activities.BaseFragmentActivity
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.EXERCISE_ID_KEY
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.PAGE_KEY
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.WORKOUT_ID_KEY
import ru.ok.technopolis.training.personal.utils.logger.Logger
import kotlin.reflect.full.createInstance

class Router(private val activity: Activity) {

    fun showLoginPage() {
        showPage(Page.Activity.Login)
    }

    fun showCalendarPage() {
        showPage(Page.Fragment.Calendar)
    }

    fun showWorkoutPage(workoutId: Long) {
        val workoutIdBundle = Bundle(1)
        workoutIdBundle.putLong(WORKOUT_ID_KEY, workoutId)
        showPage(Page.Fragment.Workout, workoutIdBundle)
    }

    fun showTrainingViewPage() {
        showPage(Page.Fragment.TrainingView)
    }

    fun showActiveExercisePage() {
        showPage(Page.Fragment.ActiveExercise)
    }

    fun showExercisePage(exerciseId: Long) {
        val exerciseIdBundle = Bundle(1)
        exerciseIdBundle.putLong(EXERCISE_ID_KEY, exerciseId)
        showPage(Page.Fragment.Exercise, exerciseIdBundle)
    }

    fun showSettingsPage() {
        showPage(Page.Activity.Settings)
    }

    fun showAccountSettingsPage() {
        showPage(Page.Activity.AccountSettings)
    }

    fun showAccountSettingsSubPage() {
        showPage(Page.Fragment.AccountSettings)
    }

    fun showRegistrationPage() {
        showPage(Page.Activity.Registration)
    }

    private fun showPage(page: Page, bundle: Bundle? = null) {
        Logger.d(this, "showPage $page")
        when (page) {
            is Page.Activity -> showActivity(page, bundle)
            is Page.Fragment -> {
                if (activity is BaseFragmentActivity) {
                    replaceFragment(page, bundle)
                } else {
                    showActivityWithFragment(page, bundle)
                }
            }
        }
    }

    private fun showActivity(page: Page.Activity, bundle: Bundle?) {
        val intent = Intent(activity, page.clazz.java)
        bundle?.let { intent.putExtras(it) }
        activity.startActivity(intent)
    }

    private fun showActivityWithFragment(page: Page.Fragment, bundle: Bundle?) {
        val intent = Intent(activity, BaseFragmentActivity::class.java)
        intent.putExtra(PAGE_KEY, page)
        bundle?.let { intent.putExtras(it) }
        activity.startActivity(intent)
    }

    private fun replaceFragment(page: Page.Fragment, bundle: Bundle?) {
        bundle?.let { activity.intent.putExtras(it) }
        (activity as? BaseFragmentActivity)?.setFragment(page.clazz.createInstance())
    }

    fun goToPrevFragment() {
        (activity as? BaseFragmentActivity)?.setPrevFragment()
    }
}