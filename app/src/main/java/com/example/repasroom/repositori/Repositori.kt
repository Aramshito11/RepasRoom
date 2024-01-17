package com.example.repasroom.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.repasroom.database.MoblesDatabase
import com.example.repasroom.model.Mobles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {

    companion object{
        var moblesDatabase: MoblesDatabase? = null

        var moble: LiveData<List<Mobles>>? = null

        fun  initializeDB(context: Context): MoblesDatabase {
            return MoblesDatabase.getDatabase(context)
        }

        fun insertMoble(context: Context, mobles: Mobles) {
            moblesDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                moblesDatabase!!.daoMobles().addMoble(mobles)
            }
        }

        fun deleteMoble(context: Context, mobles: Mobles) {
            moblesDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                moblesDatabase!!.daoMobles().deleteMoble(mobles)
            }
        }

        fun updateMoble(context: Context, mobles: Mobles) {
            moblesDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                moblesDatabase!!.daoMobles().updateMoble(mobles)
            }
        }

        fun getOneMoble(context: Context, mobles: Int): LiveData<List<Mobles>>? {

            moblesDatabase = initializeDB(context)

            moble = moblesDatabase!!.daoMobles().getOneMoble(mobles)

            return moble
        }

        fun getAllMobles(context: Context): LiveData<List<Mobles>> {

            moblesDatabase = initializeDB(context)

            return moblesDatabase!!.daoMobles().getAllMobles()
        }
    }
}