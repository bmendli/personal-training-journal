package ru.ok.technopolis.training.personal.api

import retrofit2.Callback
import retrofit2.Response
import ru.ok.technopolis.training.personal.api.responses.SuccessResponse
import ru.ok.technopolis.training.personal.dto.UserSignUpDto

/**
 *
 * High-level access to api
 *
 */
object Api {

    private val api = RetrofitApiUtils.createApi()

    /**
     *
     * Example:
     * User: class, required in our client
     * UserDto: class, that represents entity, returned from request
     *
     * Reason: sometimes it's easier to use data structure different from
     * structure retrieved from backend
     *
     * So, it's better to have two separate classes, one for data transfer
     * and one for usage in our app
     *
     * Also, other actions could be performed in these methods, including
     * subscribeOn() and observeOn()
     *
     *  fun getUserTrainings(user: User) =
     *      api.getUserTrainings(user.uid)
     *          .subscribeOn(Schedulers.io())
     *          .observeOn(AndroidSchedulers.mainThread())
     *          .map {
     *              Training.fromDto(it)
     *          }
     *          .some_other_logic
     */

    fun createUser(userSignUpDto: UserSignUpDto, callback: Callback<SuccessResponse>) = api.createUserRequest(userSignUpDto).enqueue(callback)

    fun login(token: String, callback: Callback<Response<String>>) = api.loginRequest(token).enqueue(callback)
}