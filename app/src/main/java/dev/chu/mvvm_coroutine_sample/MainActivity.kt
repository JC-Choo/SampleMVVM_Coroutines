package dev.chu.mvvm_coroutine_sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dev.chu.mvvm_coroutine_sample.databinding.ActivityMainBinding

/**
 * MVVM+Coroutines
 * https://medium.com/canopas/android-reactive-programming-with-coroutines-and-mvvm-74cd4117df3a
 *
 * Splash
 * https://medium.com/hackmobile/how-to-make-a-splash-screen-e872656c47a9
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Mvvm_coroutine_sample)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersList.adapter = UserAdapter().apply {
            model.users.observe(this@MainActivity, {
                this.users = it
            })
        }
        model.message.observe(this, {
            binding.message.text = it
        })
    }
}