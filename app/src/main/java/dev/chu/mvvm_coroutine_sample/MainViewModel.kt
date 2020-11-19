package dev.chu.mvvm_coroutine_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.chu.mvvm_coroutine_sample.data.Api
import dev.chu.mvvm_coroutine_sample.data.entity.User
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val users = MutableLiveData<List<User>>()
    val message = MutableLiveData<String>()
    init {
        viewModelScope.launch {
            try {
                message.postValue("Loading...")
                val data = Api.userServices.getUsers()
                users.postValue(data)
                message.postValue(null)
            } catch (ex: Exception) {
                message.postValue("Server encountered error.")
            }
        }
    }
}