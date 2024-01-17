package com.example.repasroom.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Mobles
import com.example.repasroom.repositori.Repositori

class VMPrincipal: ViewModel() {
    lateinit var mobles : LiveData<List<Mobles>>

    fun obtenirMobles(context: Context){
        mobles = Repositori.getAllMobles(context)
    }
}