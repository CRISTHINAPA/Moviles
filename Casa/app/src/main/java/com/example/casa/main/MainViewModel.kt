package com.example.casa.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.casa.data.CasaRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CasaRepository): ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state=state.copy(
                nombres = repository.getCasa()
            )
        }

    }

    fun onNameChange(nombre: String){
        state=state.copy(
            nombre = nombre
        )

    }

    fun onDescriptionChange(descripcion: String){
        state=state.copy(
            descripcion = descripcion
        )

    }

    fun onStorageChange(año: String){
        state=state.copy(
            año = año
        )
    }

    fun onProcessorChange(categoria: String){
        state=state.copy(
            categoria = categoria
        )

    }


    fun saveLaptop(){
        val casa= Casa(
            nombre = state.nombre,
            descripcion = state.descripcion,
            año = state.año,
            categoria = state.categoria
        )

        viewModelScope.launch {
            repository.insertCasa(casa)
        }
    }

}