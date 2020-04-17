package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.lifecycle.Page
import ru.ok.technopolis.training.personal.lifecycle.Router

class LoginActivity : BaseNoAppbarActivity() {

    private var imageView: ImageView? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var forgotPasswordTextView: TextView? = null
    private var notExistAccTextView: TextView? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        imageView = person_iv
        emailEditText = email_et
        passwordEditText = password_et
        forgotPasswordTextView = forgot_password_tv
        notExistAccTextView = not_exist_acc_tv
        loginButton = login_button
    }
}
