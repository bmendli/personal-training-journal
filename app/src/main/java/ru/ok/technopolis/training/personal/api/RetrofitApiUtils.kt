package ru.ok.technopolis.training.personal.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApiUtils {

    // todo server url
    private const val TRAINING_JOURNAL_URL = "https://<>.com/"

    @JvmStatic
    fun <T> create(clazz: Class<T>): T {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(TRAINING_JOURNAL_URL)
                .build()
                .create(clazz)
    }
}