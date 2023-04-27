package com.hiltdraggerdemo.ex6mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiltdraggerdemo.Employee
import com.hiltdraggerdemo.ex6mvvm.data.model.User
import com.hiltdraggerdemo.ex6mvvm.data.repository.MainRepository
import com.hiltdraggerdemo.ex6mvvm.utils.NetworkHelper
import com.hiltdraggerdemo.ex6mvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper) : ViewModel(){
        private val _users = MutableLiveData<Resource<List<User>>>()
        val users : LiveData<Resource<List<User>>> get() = _users
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkAvailable()) {
                mainRepository.getUsers().let {
                    if(it.isSuccessful){
                        _users.postValue(Resource.success(it.body()))
                    }else{
                        _users.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                } ?: {_users.postValue(Resource.error("Something went wrong..", null))}
            }else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}