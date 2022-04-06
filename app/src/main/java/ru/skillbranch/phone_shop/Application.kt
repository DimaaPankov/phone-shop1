package ru.skillbranch.phone_shop

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.skillbranch.phone_shop.network.service.ApiService

class Application: Application() {

    companion object {
        private const val BASE_URL = "https://run.mocky.io/"
        val retrofitService: ApiService by lazy {
            // создаём retrofit object
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(ApiService::class.java)
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}