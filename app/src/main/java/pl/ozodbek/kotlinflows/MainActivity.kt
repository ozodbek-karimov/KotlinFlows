package pl.ozodbek.kotlinflows

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.ozodbek.kotlinflows.databinding.ActivityMainBinding
import pl.ozodbek.kotlinflows.viewmodels.UserViewModel
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        launch {
            userViewModel.getStateFlow()
                .collect {
                    when {
                        it.isSuccess -> {
                            binding.tv.text = it.getOrNull().toString()
                        }

                        it.isFailure -> {
                            binding.tv.text = it.exceptionOrNull().toString()
                        }
                    }
                }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}