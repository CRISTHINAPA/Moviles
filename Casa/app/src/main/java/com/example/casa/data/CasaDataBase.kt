package com.example.casa.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CasaEntity::class], version = 1)
abstract class CasaDatabase: RoomDatabase() {

    abstract val dao: CasaDao
}