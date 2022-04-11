package ru.skillbranch.phone_shop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.skillbranch.phone_shop.entietis.BestSeller
import ru.skillbranch.phone_shop.entietis.HomeStore
import domain.usecase.GetConvertData
import ru.skillbranch.data.network.repository.DataImpl
import ru.skillbranch.phone_shop.entietis.JsonData


enum class MarsApiStatus { LOADING, ERROR, DONE }

class MainViewModel(val getConvertData:GetConvertData<JsonData> = GetConvertData(DataImpl())) : ViewModel(){
    private val _data = MutableLiveData<JsonData>()
    val data: LiveData<JsonData> = _data
    init {

        getData()


    }

   private  fun getData(){
       viewModelScope.launch {
       _data.value = getConvertData.execute()}
}

     fun getDataHome_store(): List<HomeStore>? {
        return _data.value?.home_store
    }

     fun getDataBestSeller(): List<BestSeller>? {
        return _data.value?.bestSeller
    }

}