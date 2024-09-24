package com.tks.idt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tks.idt.model.State
import com.tks.idt.repository.StateRepository

class StateViewModel : ViewModel() {
    private val repository = StateRepository()

    private val _states = MutableLiveData<List<State>>()
    val states: LiveData<List<State>> get() = _states

    private val _selectedState = MutableLiveData<State>()
    val selectedState: LiveData<State> get() = _selectedState

    init {
        _states.value = repository.getStates()
    }

    fun selectState(state: State) {
        _selectedState.value = state
        Log.d("","${_selectedState.value}")
    }

    fun filterStates(query: String) {
        _states.value = repository.getStates().filter {
            it.state.contains(query, ignoreCase = true)
        }
        Log.d("filtered data","$_states")
    }
}
