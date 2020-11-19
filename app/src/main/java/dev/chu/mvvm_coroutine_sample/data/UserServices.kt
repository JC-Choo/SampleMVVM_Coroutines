package dev.chu.mvvm_coroutine_sample.data

import dev.chu.mvvm_coroutine_sample.data.entity.User
import retrofit2.http.GET

interface UserServices {
    @GET("users")
    suspend fun getUsers(): List<User>
}