package com.example.casa.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CasaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertCasa(casa: CasaEntity)

    @Query("SELECT * FROM CasaEntity")
    suspend fun getCasas():List<CasaEntity>
}