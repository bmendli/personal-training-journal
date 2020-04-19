package ru.ok.technopolis.training.personal.api

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ok.technopolis.training.personal.BuildConfig
import ru.ok.technopolis.training.personal.utils.thread.ThreadUtils

object RetrofitApiUtils {

    val SCHEDULER = Schedulers.from(ThreadUtils.executor)

    // todo server url
    private const val TRAINING_JOURNAL_URL = "https://<>.com/"

    @JvmStatic
    fun createApi(): Api {
        val okHttpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            okHttpClient.addInterceptor(httpLoggingInterceptor)
        }

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(TRAINING_JOURNAL_URL)
                .client(okHttpClient.build())
                .build()
                .create(Api::class.java)
    }
}