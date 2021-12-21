package com.example.quotewars.inspect

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotewars.database.ActivityDatabaseDao
import com.example.quotewars.model.ActivityModel
import kotlinx.coroutines.launch

class ActivityInspectViewModel(dataSource: ActivityDatabaseDao, application: Application
):ViewModel() {
    val database = dataSource
    val quote = MutableLiveData<ActivityModel>()

    fun deleteQuote() {
        viewModelScope.launch {
            database.delete(quote.value!!)
        }
    }
    fun getQuote(id: Int){
        viewModelScope.launch {
            quote.value = database.get(id)
        }
    }
}