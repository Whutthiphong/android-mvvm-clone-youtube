package com.example.cloneyoutube.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.cloneyoutube.data.network.response.CovidResponse
import com.example.cloneyoutube.repository.IInitialRepo
import com.example.cloneyoutube.utils.BaseViewModel
import com.example.cloneyoutube.utils.UseCaseResult
import jsynctech.com.dhinternalapp.AppConfirmTOPicking.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InitialViewModel(private var repo: IInitialRepo) : BaseViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val covidResponse = MutableLiveData<CovidResponse>()
    val showError = SingleLiveEvent<String>()

    fun getCovidData() {
        showLoading.value = true
        launch {
            val result = withContext(Dispatchers.IO) {
                repo.getCovidData()
            }
            when (result) {
                is UseCaseResult.Success -> {
                    covidResponse.value = result.data
                }
                is UseCaseResult.Error -> {
                    showError.value = result.exception.message
                }
            }
            showLoading.value = false
        }
    }
}