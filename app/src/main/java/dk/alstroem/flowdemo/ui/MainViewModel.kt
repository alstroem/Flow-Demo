package dk.alstroem.flowdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.alstroem.flowdemo.data.MainRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: MainRepository
) : ViewModel() {

    private val _stateFlow = MutableStateFlow("Initial value")
    val stateFlow: StateFlow<String> = _stateFlow

    fun initStateFlow() {
        viewModelScope.launch {
            // Collect a flow
            repo.testFlow.collect { result ->
                _stateFlow.value = result
            }

            // Direct fetch
            val result = repo.fetchApiResponse()
            _stateFlow.value = result
        }
    }

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow: SharedFlow<String> = _sharedFlow


}
