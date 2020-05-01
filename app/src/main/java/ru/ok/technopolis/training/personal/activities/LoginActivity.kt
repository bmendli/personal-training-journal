package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog

import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.api.Api
import ru.ok.technopolis.training.personal.api.ApiUtils
import ru.ok.technopolis.training.personal.utils.toast.ToastUtils
import java.net.HttpURLConnection

class LoginActivity : BaseActivity(), Callback<Response<String>> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        not_exist_acc_tv.setOnClickListener {
            router?.showRegistrationPage()
        }

        confirm_button.setOnClickListener {
            Api.login(
                    ApiUtils.encodeEmailAndPasswordToAuthorizationHeader(
                            email_et.text.toString(),
                            password_et.text.toString()),
                    this
            )
        }
    }

    override fun getActivityLayoutId() = R.layout.activity_login

    override fun onFailure(call: Call<Response<String>>, t: Throwable) {
        MaterialDialog(this).show {
            title(R.string.cannot_login)
            message(R.string.failed_login)
            negativeButton(R.string.close) {
                it.cancel()
            }
        }
    }

    override fun onResponse(call: Call<Response<String>>, response: Response<Response<String>>) {
        when (response.code()) {
            HttpURLConnection.HTTP_OK -> {
                ToastUtils.showShortToast(this, R.string.successfully)
                router?.showWorkoutPage()
                finish()
            }
            HttpURLConnection.HTTP_UNAUTHORIZED -> MaterialDialog(this).show {
                title(R.string.cannot_login)
                message(R.string.incorrect_email_or_password)
                negativeButton(R.string.close) {
                    it.cancel()
                }
            }
            HttpURLConnection.HTTP_NOT_FOUND -> MaterialDialog(this).show {
                title(R.string.cannot_login)
                message(R.string.server_not_available)
                negativeButton(R.string.close) {
                    it.cancel()
                }
            }
        }
    }
}
