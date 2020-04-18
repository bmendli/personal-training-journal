package ru.ok.technopolis.training.personal.activities

import android.content.Context
import android.os.Bundle
import ru.ok.technopolis.training.personal.R

class WelcomeActivity : BaseNoAppbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        // TODO: this is the mock for authorisation, implement this later
        val authorised = getSharedPreferences("Training", Context.MODE_PRIVATE).getBoolean("isAuthorised", false)

        if (authorised) {
            router?.showWorkoutPage()
        } else {
            router?.showLoginPage()
        }
        finish()
    }

}