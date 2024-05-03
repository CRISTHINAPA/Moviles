package com.example.casa.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CasaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nombre: String,
    val descripcion: String,
    val año: String,
    val categoria: String,
)
