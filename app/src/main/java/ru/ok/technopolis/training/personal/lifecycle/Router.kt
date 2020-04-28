package ru.ok.technopolis.training.personal.lifecycle

import android.app.Activity
import android.content.Intent
import ru.ok.technopolis.training.personal.activities.BaseFragmentActivity
import ru.ok.technopolis.training.personal.lifecycle.Page.Companion.PAGE_KEY
import ru.ok.technopolis.training.personal.utils.logger.Logger
import kotlin.reflect.full.createInstance

class Router(private val activity: Activity) {

    fun showLoginPage() {
        showPage(Page.Activity.Login)
    }

    fun showCalendarPage() {
        showPage(Page.Fragment.Calendar)
    }

    fun showWorkoutPage() {
        showPage(Page.Fragment.Workout)
    }

    fun showActiveExercisePage() {
        showPage(Page.Activity.ActiveExercise)
    }

    fun showExercisePage() {
        showPage(Page.Fragment.Exercise)
    }

    fun showSettingsPage() {
        showPage(Page.Activity.Settings)
    }

    private fun showPage(page: Page) {
        Logger.d(this, "showPage $page")
        when (page) {
            is Page.Activity -> showActivity(page)
            is Page.Fragment -> {
                if (activity is BaseFragmentActivity) {
                    replaceFragment(page)
                } else {
                    showActivityWithFragment(page)
                }
            }
        }
    }

    private fun showActivity(page: Page.Activity) {
        val intent = Intent(activity, page.clazz.java)
        activity.startActivity(intent)
    }

    private fun showActivityWithFragment(page: Page.Fragment) {
        val intent = Intent(activity, BaseFragmentActivity::class.java)
        intent.putExtra(PAGE_KEY, page)
        activity.startActivity(intent)
    }

    private fun replaceFragment(page: Page.Fragment) {
        (activity as? BaseFragmentActivity)?.setFragment(page.clazz.createInstance())
    }
}