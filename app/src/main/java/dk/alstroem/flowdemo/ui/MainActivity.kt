package dk.alstroem.flowdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dk.alstroem.flowdemo.data.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val repository = MainRepository()
    private val viewModel = MainViewModel(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Incorrect - keeps consuming results even when it's in the background - potential leak or crash
        lifecycleScope.launch {
            viewModel.stateFlow.collect {  }
        }

        // Listen to multiple flows
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateFlow.collect {  }
            }
        }

        // Listen to a single flow
        lifecycleScope.launch {
            viewModel.stateFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {  }
        }
    }
}
