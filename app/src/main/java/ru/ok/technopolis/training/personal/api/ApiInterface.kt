package ru.ok.technopolis.training.personal.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import ru.ok.technopolis.training.personal.api.responses.SuccessResponse
import ru.ok.technopolis.training.personal.dto.UserSignUpDto

/**
 * Your Request-methods should be here
 */
interface ApiInterface {

    /**
     * @GET("path/path...")
     * fun getUserTrainings(userId: String): Single<TrainingDto>
     */

    @Headers("Content-Type: application/json")
    @POST("/users/create")
    fun createUserRequest(@Body userSignUpDto: UserSignUpDto): Call<SuccessResponse>

    @GET("/users/login")
    fun loginRequest(@Header("Authorization") token: String): Call<Response<String>>
}