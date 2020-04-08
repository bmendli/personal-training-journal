package ru.ok.technopolis.training.personal.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import ru.ok.technopolis.training.personal.BaseActivity
import ru.ok.technopolis.training.personal.R

class LoginActivity : BaseActivity() {

    private val imageView: ImageView = findViewById(R.id.person_iv)
    private val emailEditText: EditText = findViewById(R.id.email_et)
    private val passwordEditText: EditText = findViewById(R.id.password_et)
    private val forgotPasswordTextView: TextView = findViewById(R.id.forgot_password_tv)
    private val notExistAccTextView: TextView = findViewById(R.id.not_exist_acc_tv)
    private val loginButton: Button = findViewById(R.id.login_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int = R.layout.activity_login
}
