package ru.ok.technopolis.training.personal.activities

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.fragments.LoginFragment

class LoginActivity : BaseNoAppbarActivity() {

    override fun getSupportingFragmentClass(): Class<out Fragment> = LoginFragment::class.java
}
