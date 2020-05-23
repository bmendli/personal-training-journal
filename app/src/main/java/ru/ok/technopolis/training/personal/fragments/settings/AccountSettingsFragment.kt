package ru.ok.technopolis.training.personal.fragments.settings

import android.Manifest
import android.Manifest.permission
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import kotlinx.android.synthetic.main.fragment_account_settings.*
import retrofit2.Response
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.api.Api
import ru.ok.technopolis.training.personal.dto.UserDto
import ru.ok.technopolis.training.personal.fragments.BaseFragment
import ru.ok.technopolis.training.personal.repository.CurrentUserRepository
import ru.ok.technopolis.training.personal.utils.logger.Logger
import ru.ok.technopolis.training.personal.utils.toast.ToastUtils
import ru.ok.technopolis.training.personal.utils.validator.UserValidator
import java.net.HttpURLConnection

class AccountSettingsFragment : BaseFragment() {

    companion object {
        const val CAMERA_PERMISSION_REQUEST_CODE = 999;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = CurrentUserRepository.currentUser
        currentUser?.let { user ->
            last_name_header.text = user.lastName
            first_name_header.text = user.firstName
            father_name_header.text = user.fatherName
            user_image.setImageURI(user.pictureUrlStr)

            context?.let {
                last_name_ll.setOnClickListener { _ ->
                    MaterialDialog(it).show {
                        title(R.string.last_name)
                        negativeButton(R.string.close) { mt ->
                            mt.cancel()
                        }
                        input(
                                prefill = user.lastName,
                                maxLength = 30,
                                callback = { dialog, lastName ->
                                    val lastNameStr = lastName.toString()
                                    if (UserValidator.validName(lastNameStr)) {
                                        val userDto = user.toUserDto()
                                        userDto.lastName = lastNameStr

                                        taskContainer.add(Api.changeUserData(
                                                userDto,
                                                CurrentUserRepository.getCurrentUserToken(it) ?: ""
                                        ).subscribe(
                                                { response -> onResponse(response, userDto) },
                                                { throwable -> onFail(throwable) }
                                        ))

                                    } else {
                                        ToastUtils.showLongToast(it, R.string.incorrect_last_name)
                                    }
                                }
                        )

                    }
                }
                first_name_ll.setOnClickListener { _ ->
                    MaterialDialog(it).show {
                        title(R.string.first_name)
                        negativeButton(R.string.close) { mt ->
                            mt.cancel()
                        }
                        input(
                                prefill = user.firstName,
                                maxLength = 30,
                                callback = { dialog, firstName ->
                                    val firstNameStr = firstName.toString()
                                    if (UserValidator.validName(firstNameStr)) {
                                        val userDto = user.toUserDto()
                                        userDto.firstName = firstNameStr

                                        taskContainer.add(Api.changeUserData(
                                                userDto,
                                                CurrentUserRepository.getCurrentUserToken(it) ?: ""
                                        ).subscribe(
                                                { response -> onResponse(response, userDto) },
                                                { throwable -> onFail(throwable) }
                                        ))

                                    } else {
                                        ToastUtils.showLongToast(it, R.string.incorrect_first_name)
                                    }
                                }
                        )

                    }
                }
                father_name_ll.setOnClickListener { _ ->
                    MaterialDialog(it).show {
                        title(R.string.father_name)
                        negativeButton(R.string.close) { mt ->
                            mt.cancel()
                        }
                        input(
                                prefill = user.fatherName,
                                maxLength = 30,
                                callback = { dialog, fatherName ->
                                    val fatherNameStr = fatherName.toString()
                                    if (UserValidator.validName(fatherNameStr)) {
                                        val userDto = user.toUserDto()
                                        userDto.fatherName = fatherNameStr

                                        taskContainer.add(Api.changeUserData(
                                                userDto,
                                                CurrentUserRepository.getCurrentUserToken(it) ?: ""
                                        ).subscribe(
                                                { response -> onResponse(response, userDto) },
                                                { throwable -> onFail(throwable) }
                                        ))

                                    } else {
                                        ToastUtils.showLongToast(it, R.string.incorrect_father_name)
                                    }
                                }
                        )

                    }
                }
                user_image_ll.setOnClickListener { _ ->
                }
            }
        }
    }

    private fun onResponse(response: Response<UserDto>, userDto: UserDto) {
        when (response.code()) {
            HttpURLConnection.HTTP_OK -> {
                CurrentUserRepository.currentUser = userDto.toUserInfo()
                last_name_header.text = userDto.lastName
                first_name_header.text = userDto.firstName
                father_name_header.text = userDto.fatherName
                user_image.setImageURI(userDto.pictureUrlStr)
                Logger.d(this, "successfully changed user data with code ${response.code()}")
            }
            else -> {
                context?.let {
                    ToastUtils.showLongToast(it, R.string.server_not_available)
                }
                Logger.d(this, "unsuccessfully changed user data with code ${response.code()}")

            }
        }
    }

    private fun onFail(throwable: Throwable) {
        context?.let {
            ToastUtils.showLongToast(it, R.string.failed_change_user_data)
        }
        Logger.e(this, "Login failed : ${throwable.message}")
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_account_settings
}