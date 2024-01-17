package com.example.repasroom.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.example.repasroom.model.Mobles

@Dao
interface DaoMobles {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addMoble(mobles: Mobles)

    @Delete()
    fun deleteMoble(mobles: Mobles)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateMoble(mobles: Mobles)

    @Query("SELECT * FROM Mueble WHERE id = :identificador ORDER BY id DESC")
    fun getOneMoble(identificador:Int): LiveData<List<Mobles>>

    @Query("SELECT * FROM mueble ORDER BY id DESC")
    fun getAllMobles(): LiveData<List<Mobles>>
}