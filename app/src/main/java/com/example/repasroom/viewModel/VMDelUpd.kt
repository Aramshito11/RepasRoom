package com.example.repasroom.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Mobles
import com.example.repasroom.repositori.Repositori

class VMDelUpd : ViewModel(){
    var mobles : LiveData<List<Mobles>>?=null

    fun updateMoble(context: Context, mobles: Mobles){
        Repositori.updateMoble(context, mobles)
    }

    fun deleteMoble(context: Context, mobles: Mobles){
        Repositori.deleteMoble(context,mobles)
    }

    fun selectMoble(context: Context, id: Int){
        Repositori.getOneMoble(context,id)
    }
}