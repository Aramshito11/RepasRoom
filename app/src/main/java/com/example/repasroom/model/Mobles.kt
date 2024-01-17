package com.example.repasroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mueble")
data class Mobles (
    @ColumnInfo(name = "nom")
    var nom: String,
    @ColumnInfo(name = "preu")
    var preu: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}