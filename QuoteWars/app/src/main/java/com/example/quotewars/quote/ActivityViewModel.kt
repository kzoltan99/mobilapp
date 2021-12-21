package com.example.quotewars.quote

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.quotewars.database.ActivityDatabaseDao
import com.example.quotewars.model.ActivityModel
import com.example.quotewars.network.SWApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ActivityViewModel(dataSource: ActivityDatabaseDao, application: Application
): ViewModel() {
    private val _response = MutableLiveData<ActivityModel>()
    private val database = dataSource
    val allQuotes = database.getAllQuotes()


    fun response(): LiveData<ActivityModel> {
        return _response
    }

    init {
        getStarWarsQuote()
    }
    fun addToFavorite(){
        viewModelScope.launch {
            insertQuoteToFavorites(_response.value!!)
        }
    }
    private suspend fun insertQuoteToFavorites(quote: ActivityModel) {
        database.insert(quote)
    }

    fun getStarWarsQuote() {
        viewModelScope.launch() {
            try{
                val result = withContext(Dispatchers.IO){ SWApi.retrofitService.getQuote()}
                Log.i("apiCall","The activity: ${result.activity}")
                _response.value = result
            }catch (e: Exception){
                Log.w("apiCall",e)
            }
        }
    }
}