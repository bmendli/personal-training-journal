package ru.ok.technopolis.training.personal.activities

import android.graphics.Color
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.api.Api
import ru.ok.technopolis.training.personal.api.responses.SuccessResponse
import ru.ok.technopolis.training.personal.model.UserSignUpInfo
import ru.ok.technopolis.training.personal.utils.auth.AuthorizationHelper
import ru.ok.technopolis.training.personal.utils.auth.SignUpDataCorrectType
import ru.ok.technopolis.training.personal.utils.logger.Logger
import ru.ok.technopolis.training.personal.utils.toast.ToastUtils
import java.net.HttpURLConnection

class RegistrationActivity : BaseActivity(), Callback<SuccessResponse> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cancel_button.setOnClickListener { finish() }
        confirm_button.setOnClickListener {
            resetRequiredTips()
            val userSignUpInfo = UserSignUpInfo(
                    email_et.text.toString(),
                    password_et.text.toString(),
                    confirm_password_et.text.toString(),
                    last_name_et.text.toString(),
                    first_name_et.text.toString(),
                    user_gender.selectedItem as? String
            )
            when (AuthorizationHelper.checkCorrectnessInputData(userSignUpInfo)) {
                SignUpDataCorrectType.INCORRECT_EMAIL -> {
                    email_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_email)
                }
                SignUpDataCorrectType.INCORRECT_PASSWORD -> {
                    password_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_password)
                }
                SignUpDataCorrectType.INCORRECT_CONFIRM_PASSWORD -> {
                    confirm_password_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_confirm_passowrd)
                }
                SignUpDataCorrectType.INCORRECT_LAST_NAME -> {
                    last_name_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_last_name)
                }
                SignUpDataCorrectType.INCORRECT_FIRST_NAME -> {
                    first_name_required.setTextColor(Color.RED)
                    ToastUtils.showShortToast(this, R.string.incorrect_first_name)
                }
                SignUpDataCorrectType.CORRECT -> Api.createUser(userSignUpInfo.toUserSignUpDto(), this)
            }
        }
    }

    private fun resetRequiredTips() {
        email_required.setTextColor(Color.BLACK)
        password_required.setTextColor(Color.BLACK)
        confirm_password_required.setTextColor(Color.BLACK)
        last_name_required.setTextColor(Color.BLACK)
        first_name_required.setTextColor(Color.BLACK)
        user_gender_required.setTextColor(Color.BLACK)
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_registration

    override fun onFailure(call: Call<SuccessResponse>, t: Throwable) {
        ToastUtils.showErrorToast(this)
        Logger.e(this, t.message ?: t)
    }

    override fun onResponse(call: Call<SuccessResponse>, response: Response<SuccessResponse>) {
        if (response.code() == HttpURLConnection.HTTP_CREATED) {
            ToastUtils.showShortToast(this, R.string.successfully)
            finish()
        } else {
            ToastUtils.showShortToast(this, R.string.failed_registr)
        }
    }
}