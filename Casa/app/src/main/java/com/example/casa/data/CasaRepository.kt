package com.example.casa.data

import com.example.casa.main.Casa

class CasaRepository(private val casaDao:CasaDao) {

        suspend fun getCasa(): List<Casa> {
            val entities = casaDao.getCasas()
            return entities.map {
                Casa(nombre = it.nombre, descripcion = it.descripcion, año = it.año, categoria = it.categoria)
            }
        }

        suspend fun insertCasa(casa: Casa) {
            val entity =CasaEntity(nombre = casa.nombre, descripcion = casa.descripcion, año = casa.año, categoria = casa.categoria)
            casaDao.insertCasa(entity)
        }
}