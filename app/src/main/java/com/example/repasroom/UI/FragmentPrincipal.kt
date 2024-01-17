package com.example.repasroom.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repasroom.R
import com.example.repasroom.databinding.FragmentPrincipalBinding
import com.example.repasroom.viewModel.VMPrincipal


class FragmentPrincipal : Fragment() {
    private lateinit var binding: FragmentPrincipalBinding
    private lateinit var mobleViewModel: VMPrincipal
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_principal, container, false
        )

        mobleViewModel = ViewModelProvider(this).get(VMPrincipal::class.java)

        recyclerView = binding.recyclerViewMobles

        recyclerView.layoutManager = LinearLayoutManager(activity)


        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentPrincipal_to_fragmentAdd, null)
        }

        mobleViewModel.obtenirMobles(requireContext())

        mobleViewModel.mobles.observe(viewLifecycleOwner){ llistaMobles-> binding.recyclerViewMobles.adapter = MoblesAdapter(llistaMobles)
        }

        return binding.root
    }
}