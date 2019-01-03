package com.example.yesidmarin.nutritionalplan.network


import com.example.yesidmarin.nutritionalplan.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class APiFactory {

    init {
        setup()
    }

    companion object {

        var BASE_URL = BuildConfig.BASE_URL
        private var retrofit: Retrofit.Builder? = null

        fun build(): Services? {
            return setup()?.build()?.create<Services>(Services::class.java)
        }

        private fun setup(): Retrofit.Builder? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BASIC
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                retrofit?.client(client)
                    ?.baseUrl(BASE_URL)
                    ?.addConverterFactory(GsonConverterFactory.create())
                    ?.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            }

            return retrofit
        }
    }
}