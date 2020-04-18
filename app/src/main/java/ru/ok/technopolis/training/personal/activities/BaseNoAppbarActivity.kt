package ru.ok.technopolis.training.personal.activities

import kotlinx.android.synthetic.main.activity_no_appbar.*
import ru.ok.technopolis.training.personal.R

abstract class BaseNoAppbarActivity : BaseActivity() {

    override fun setupActivity() {
        mainContainer = main_container
    }

    override fun isToolbarEnabled(): Boolean = false

    override fun hasNavigationMenu(): Boolean = false

    override fun getActivityLayoutId(): Int = R.layout.activity_no_appbar
}