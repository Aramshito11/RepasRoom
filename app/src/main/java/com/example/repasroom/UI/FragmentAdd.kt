package com.example.repasroom.UI

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.repasroom.R
import com.example.repasroom.database.MoblesDatabase
import com.example.repasroom.databinding.FragmentAddBinding
import com.example.repasroom.databinding.FragmentPrincipalBinding
import com.example.repasroom.model.Mobles
import com.example.repasroom.viewModel.VMAdd
import com.example.repasroom.viewModel.VMPrincipal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentAdd : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mobleViewModel: VMAdd
    var moblesDatabase: MoblesDatabase? = null

    var moble: LiveData<List<Mobles>>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add, container, false
        )

        mobleViewModel = ViewModelProvider(this).get(VMAdd::class.java)

        binding.button2.setOnClickListener {

            val nom= binding.editTextText.text.toString()
            val preu =binding.editTextText2.text.toString().toInt()


            mobleViewModel.afegirMoble(requireContext(), nom, preu)
            findNavController().navigate(R.id.action_fragmentAdd_to_fragmentPrincipal, null)
        }

        return binding.root
    }


}