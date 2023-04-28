package com.hiltdraggerdemo.ex7mvvmflows.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiltdraggerdemo.ex7mvvmflows.data.repositry.MainRepository
import com.hiltdraggerdemo.ex7mvvmflows.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {
    sealed class QuotesEvent{
        class Success(val resultText:String):QuotesEvent()
        class Failure(val errorText:String):QuotesEvent()
        object Loading:QuotesEvent()
        object Empty:QuotesEvent()
    }
    private val _myFlowData = MutableStateFlow<QuotesEvent>(QuotesEvent.Empty)
    val flowData: StateFlow<QuotesEvent> get() = _myFlowData

    fun getQuote(){
        viewModelScope.launch(Dispatchers.IO) {
            _myFlowData.value =  QuotesEvent.Loading
            when(val quotesResponse = repository.getQuotes()) {
                is Resource.Error -> _myFlowData.value = QuotesEvent.Failure(quotesResponse.message!!)
                is Resource.Success -> {
                    val quote = quotesResponse.data!!.quote
                    if(quote == null) {
                        _myFlowData.value = QuotesEvent.Failure("Unexpected error")
                    } else {
                        _myFlowData.value = QuotesEvent.Success("$quote")
                    }
                }
                else -> {}
            }
        }
    }
}