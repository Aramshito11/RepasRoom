package com.example.repasroom.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Mobles
import com.example.repasroom.repositori.Repositori

class VMAdd: ViewModel() {
//    var mobles : LiveData<List<Mobles>>?=null

    fun afegirMoble(context: Context, nom: String, preu: Int){
        var cotxeVM=Mobles(nom, preu)

        Repositori.insertMoble(context, cotxeVM)
    }
}