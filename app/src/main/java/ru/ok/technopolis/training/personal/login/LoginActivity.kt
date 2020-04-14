package ru.ok.technopolis.training.personal.login

import androidx.fragment.app.Fragment
import ru.ok.technopolis.training.personal.base.BaseNoAppbarActivity

class LoginActivity : BaseNoAppbarActivity() {

    override fun getSupportingFragmentClass(): Class<out Fragment> = LoginFragment::class.java
}
