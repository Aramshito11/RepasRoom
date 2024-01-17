package com.example.repasroom.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.repasroom.R
import com.example.repasroom.databinding.RecicleviewBinding
import com.example.repasroom.model.Mobles

class MoblesAdapter (private val mobleList:List<Mobles>) : RecyclerView.Adapter<MoblesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoblesViewHolder {
        val layoutInflater = RecicleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoblesViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = mobleList.size

    override fun onBindViewHolder(holder: MoblesViewHolder, position: Int) {
        val item = mobleList[position]
        holder.render(item)

    }

}

class MoblesViewHolder(private var binding: RecicleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(mobles: Mobles){
        binding.textViewNombre.text = mobles.nom
        binding.textViewPrecio.text = mobles.preu.toString()
    }
}