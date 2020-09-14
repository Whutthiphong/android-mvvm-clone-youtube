package com.example.cloneyoutube.data.network

import com.example.cloneyoutube.data.network.response.CovidResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface IApi {
    @GET("/api/v1/cases/countries-search")
    fun getCovidData(): Deferred<CovidResponse>
}