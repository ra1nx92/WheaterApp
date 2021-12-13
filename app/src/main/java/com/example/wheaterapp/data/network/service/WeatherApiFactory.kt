package com.example.wheaterapp.data.network.service

import com.example.wheaterapp.data.network.service.model.WeatherModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiFactory {

    private const val BASE_URL = "https://api.openweathermap.org/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(WeatherApi::class.java)


    fun getDataService(cityName:String): Single<WeatherModel>{
        return retrofit.getWeatherData(cityName)
    }
}