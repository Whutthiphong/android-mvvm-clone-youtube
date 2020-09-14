package com.example.cloneyoutube.repository

import com.example.cloneyoutube.data.network.IApi
import com.example.cloneyoutube.data.network.response.CovidResponse
import com.example.cloneyoutube.utils.UseCaseResult
import com.example.cloneyoutube.utils.UseCaseResult.Error
import com.example.cloneyoutube.utils.UseCaseResult.Success

class InitialRepo(private val api:IApi) :IInitialRepo {
    override suspend fun getCovidData(): UseCaseResult<CovidResponse> {
        return try {
            val result = api.getCovidData().await()
            Success(result)
        } catch (ex: Exception) {
            Error(ex)
        }
    }
}