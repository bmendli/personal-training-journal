package ru.ok.technopolis.training.personal.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.base.BaseFragment

class LoginFragment : BaseFragment() {

    private var imageView: ImageView? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var forgotPasswordTextView: TextView? = null
    private var notExistAccTextView: TextView? = null
    private var loginButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(getFragmentLayoutId(), container, false) as ViewGroup
        imageView = root.findViewById(R.id.person_iv)
        emailEditText = root.findViewById(R.id.email_et)
        passwordEditText = root.findViewById(R.id.password_et)
        forgotPasswordTextView = root.findViewById(R.id.forgot_password_tv)
        notExistAccTextView = root.findViewById(R.id.not_exist_acc_tv)
        loginButton = root.findViewById(R.id.login_button)
        return root
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_login
}