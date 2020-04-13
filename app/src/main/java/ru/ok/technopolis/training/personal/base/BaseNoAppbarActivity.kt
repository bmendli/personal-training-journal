package ru.ok.technopolis.training.personal.base

import ru.ok.technopolis.training.personal.R

abstract class BaseNoAppbarActivity : BaseActivity() {

    override fun isToolbarEnabled(): Boolean = false

    override fun getActivityLayoutId(): Int = R.layout.activity_no_appbar
}