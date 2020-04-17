package ru.ok.technopolis.training.personal.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.lifecycle.Page
import ru.ok.technopolis.training.personal.lifecycle.Router

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        val router = Router(this)

        // TODO: this is the mock for authorisation, implement this later
        val authorised = getSharedPreferences("Training", Context.MODE_PRIVATE).getBoolean("isAuthorised", false)

        if (authorised) {
            router.showPage(Page.Fragment.Workout)
        } else {
            router.showPage(Page.Activity.Login)
        }
        finish()
    }

}