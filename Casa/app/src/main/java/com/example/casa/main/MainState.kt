package com.example.casa.main

data class MainState (
    val nombre: String="",
    val descripcion: String="",
    val año: String="",
    val categoria: String="",
    val nombres: List<Casa> = emptyList()
)